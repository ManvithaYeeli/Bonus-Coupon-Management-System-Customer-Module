package com.wise.bcms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wise.bcms.dao.CompanyDAO;
import com.wise.bcms.dao.CustomerDAO;
import com.wise.bcms.dao.OrderDAO;
import com.wise.bcms.dao.OrderLineDAO;
import com.wise.bcms.dao.ProductDAO;
import com.wise.bcms.dto.Company;
import com.wise.bcms.dto.Customer;
import com.wise.bcms.dto.Order;
import com.wise.bcms.dto.OrderLine;
import com.wise.bcms.dto.Product;
import com.wise.bcms.util.DBUtility;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/BCMSController")
public class BCMSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY="products";
    private static final int THRESHOLD_SIZE=1024*1024*3;
    private static final int MAX_FILE_SIZE=1024*1024*40;
    private static final int MAX_REQUEST_SIZE=1024*1024*50;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCMSController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if (action.equals("customer")) {
			response.sendRedirect("customerLogin.jsp");
			return;
		}
		if (action.equals("company")) {
			response.sendRedirect("companyLogin.jsp");
			return;
		}
		
		if(action.equals("customerProfile")){
			displayProfile(request).forward(request,response);
			
		}
		if(action.equals("products")){
			displayProducts(request).forward(request,response);
			return;
		}
		if(action.equals("order")) {
			displayOrder(request).forward(request,response);
		}
		if(action.equals("orderLine")) {
	//		displayOrderLine(request).forward(request,response);
		}
		
	}

	private RequestDispatcher displayOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub
		OrderDAO dao = new OrderDAO();
		List<Order>  orderList = new ArrayList<Order>();
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("cuser");
		System.out.println(customer.getId());
		orderList = dao.get(customer.getId());
		for (Order order : orderList) {
			System.out.println(order.getStatus());
		}
		request.setAttribute("orderList", orderList);
	return request.getRequestDispatcher("displayOrders.jsp");
		//return null;
	}

	private RequestDispatcher displayProducts(HttpServletRequest request) {
		// TODO Auto-generated method stub		
		
		ProductDAO productDao = new ProductDAO();
		List<Product>  productList = new ArrayList<Product>();
		productList = productDao.get();
		//HttpSession session = request.getSession();
		//session.setAttribute("productList",productList);
		//dispatcher=request.getRequestDispatcher("customerPanel.jsp");

		//System.out.println(" size" + productList.size());		
		request.setAttribute("productList", productList);
		
		return request.getRequestDispatcher("displayProducts.jsp");

	}

	private RequestDispatcher loginAsCustomer(HttpServletRequest request) {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.get(Integer.parseInt(id));
		//System.out.println((customer.getPassword()).equals(password));
		if((customer.getPassword()).equals(password)) {
			HttpSession session1 = request.getSession();
			session1.setAttribute("cuser",customer);
			dispatcher=request.getRequestDispatcher("customerPanel.jsp");
		}
		else {
			dispatcher = request.getRequestDispatcher("customerLogin.jsp");
		}
		return dispatcher;
	}

	private RequestDispatcher registerAsCustomer(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String companyId = request.getParameter("companyId");
		
		CompanyDAO companyDao = new CompanyDAO();
		Company company=companyDao.get(Integer.parseInt(companyId));
		
		if(company!=null){
			Customer customer=new Customer();
			Company compani=new Company();
			compani.setId(Integer.parseInt(companyId));
			
				customer.setCompany(compani);
				customer.setId(Integer.parseInt(request.getParameter("id")));
				customer.setName(request.getParameter("first_name"));
				customer.setSurname(request.getParameter("last_name"));
				customer.setDob(DBUtility.convertFromUTILDateToSQLDate(DBUtility.convertStringDateToUtilDate(request.getParameter("dob"))));
				customer.setGender(request.getParameter("gender"));
				customer.setEmail(request.getParameter("email_id"));
				customer.setPassword(request.getParameter("password"));
				customer.setPhno(request.getParameter("phoneno"));
				
				
				customer.setHouseno(request.getParameter("houseNo"));
				customer.setLocation(request.getParameter("location"));
				customer.setCity(request.getParameter("city"));
				customer.setState(request.getParameter("state"));
				customer.setCountry(request.getParameter("country"));
				customer.setPincode(Integer.parseInt(request.getParameter("pincode")));
				
				CustomerDAO dao = new CustomerDAO();
				

		int status = dao.add(customer);
	if(status >= 0) {
			request.setAttribute("registrationStatus:","registration successful");
		}
		else {
			request.setAttribute("registrationStatus:","registration failed");
		}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("customerSignup.jsp");
		
 		return rd;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        try {
  
            if(isMultipart) {
              //System.out.println("kjfbdjsbflj");
              // Create a factory for disk-based file items
              DiskFileItemFactory factory = new DiskFileItemFactory();
             factory.setSizeThreshold(THRESHOLD_SIZE);
             factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

              // Create a new file upload handler
              ServletFileUpload upload = new ServletFileUpload(factory);
              upload.setFileSizeMax(MAX_FILE_SIZE);
              upload.setSizeMax(MAX_REQUEST_SIZE);

              String uploadFolder = getServletContext().getInitParameter("imageupload")
                      +File.separator+UPLOAD_DIRECTORY;

              File uploadDir=new File(uploadFolder);

              if(!uploadDir.exists()){
                  uploadDir.mkdir();
              }


              // Parse the request
              List  items = upload.parseRequest(request);
              System.out.println("size is:"+items.size());
              // Process the uploaded items
              Iterator iter = items.iterator();
              int productId = 0;
              while (iter.hasNext()) {
                      System.out.println("in while");
                  FileItem item = (FileItem) iter.next();
                  if (item.isFormField()) {
                      productId = Integer.parseInt(item.getString());
                  }
                  else {
                      String fileName = new File(item.getName()).getName();
                      fileName = productId + "_" + fileName;
                      String filePath = uploadFolder + File.separator + fileName;
                      File uploadedFile = new File(filePath);

                      item.write(uploadedFile);

                      ProductDAO dao=new ProductDAO();
                      dao.updateImg(productId, fileName);
                  }
              }
              return;
         }
      }
         catch (Exception e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();            
                      
      }
        String action = request.getParameter("action");
 	   System.out.println(action);
        if ("customerLogin".equals(action)) {
			loginAsCustomer(request).forward(request,response);
			return;
		}
		if("customerSignup".equals(action)) {
			registerAsCustomer(request).forward(request,response);
			return;
		}  
		if("placeOrder".equals(action)) {
			placeAnOrder(request).forward(request,response);
			return;
		}  
		
		
		if("addToCart".equals(action)) {
			addToCart(request).forward(request, response);
			return;
		}
	

		
	}

	/*private String[] extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] item = contentDisp.split("_");
		// TODO Auto-generated method stub
		return item;
	}*/

	private RequestDispatcher placeAnOrder(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<OrderLine> list = new ArrayList<OrderLine>();
		OrderLineDAO dao = new OrderLineDAO();
		OrderLine orderLine = new OrderLine();
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("cuser");
		
		
		list = dao.get(customer.getId(),(int)session.getAttribute("orderId"));
		
		request.setAttribute("placeOrder", list);
		
		return request.getRequestDispatcher("displayOrders.jsp");
	}

	private RequestDispatcher addToCart(HttpServletRequest request) {
		// TODO Auto-generated method stub
		OrderDAO orderDAO = new OrderDAO();
		OrderLineDAO orderLineDAO = new OrderLineDAO();
		OrderLine orderLine = new OrderLine();
		Order order = new Order();
		Product product = new Product();
		int orderId = 0;
		System.out.println("in ");
		HttpSession session = request.getSession(false);
		if(session.getAttribute("orderId") == null) {
			System.out.println("in if");
			orderId = orderDAO.getTransactionId();
			HttpSession session2 = request.getSession();
			session2.setAttribute("orderId", orderId);
			product.setId(Integer.parseInt(request.getParameter("ProductId")));
			orderLine.setProduct(product);
			System.out.println(request.getParameter("ProductPrice"));
			orderLine.setPrice(Double.parseDouble(request.getParameter("ProductPrice"))*Integer.parseInt(request.getParameter("quantity")));
			orderLine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			order.setId(orderId);
			orderLine.setOrder(order);
			Customer customer = (Customer) session.getAttribute("cuser");
			order.setCustomer(customer);
			//order.setStatus("pending");
			order.setDate(new java.sql.Date(System.currentTimeMillis()));
			orderDAO.add(order);
			orderLineDAO.add(orderLine);
		}
		else {
			System.out.println("in else");
		orderId =	(int) session.getAttribute("orderId");
		product.setId(Integer.parseInt(request.getParameter("ProductId")));
			orderLine.setProduct(product);
			orderLine.setPrice(Double.parseDouble(request.getParameter("ProductPrice")));
			orderLine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			order.setId(orderId);
			orderLine.setOrder(order);
			orderLineDAO.add(orderLine);
		}
		ProductDAO productDao = new ProductDAO();
		List<Product>  productList = new ArrayList<Product>();
		productList = productDao.get();
		request.setAttribute("productList",productList);
		
		return request.getRequestDispatcher("displayProducts.jsp");
	}

	private RequestDispatcher displayProfile(HttpServletRequest request) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("customerProfile.jsp");
		return requestDispatcher;
	}

}