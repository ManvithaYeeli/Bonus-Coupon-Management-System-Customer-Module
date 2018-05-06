package com.wise.bcms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.bcms.dto.Coupon;
import com.wise.bcms.dto.Employee;
import com.wise.bcms.dto.Order;
import com.wise.bcms.dto.OrderLine;
import com.wise.bcms.dto.Product;
import com.wise.bcms.util.DBUtility;

public class ProductDAO {
	
	
	//adding products
	public int add(Product product) {
		int status = 0;
		final String QUERY = "insert into products(product_id,product_name,description,price,picture)values(?,?,?,?,?)";
		try(Connection connection = DBUtility.getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setString(3,product.getDescription());
			preparedStatement.setDouble(4,product.getPrice());
			preparedStatement.setString(5, product.getPicture());
			status = preparedStatement.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return status;
		
	}
	
	//returns product based on product id
	public Product get(int productId) {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Product product = new Product();
		final String QUERY = "select product_id, product_name, description, price from products where product_id = ?";
		try(Connection connection = DBUtility.getConnection()){
			preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, productId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setDescription(resultSet.getString(3));
				product.setPrice(resultSet.getInt(4));
				product.setPicture(resultSet.getString(5));
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DBUtility.close(resultSet,preparedStatement);
		}

		return product;
	}
	
	
	//returns list of products
	public List<Product> get(){
		final String QUERY = "select product_id, product_name, description, price, picture from products";
    	ResultSet resultSet = null;
    	List<Product> list = new ArrayList<Product>();
    	PreparedStatement preparedStatement = null;
    	try(Connection connection = DBUtility.getConnection()) {
    		preparedStatement = connection.prepareStatement(QUERY);
    		resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setDescription(resultSet.getString(3));
				product.setPrice(resultSet.getDouble(4));
				product.setPicture(resultSet.getString(5));	
				list.add(product);
			}
    	}catch(SQLException exception) {
    		exception.printStackTrace();
    	}
    	finally {
    		DBUtility.close(preparedStatement,resultSet);
    	}
		return list;	
	}
	
	/*
	public List<OrderLine> getProduct(int orderId) {
		final String QUERY = "select o.order_date,ol.product_id, ol.price, p.product_name, p.picture from orders o, orders_line ol, products p where ol.orders_id = o.orders_id and p.products_id = ol.products_id and o.orders_id = ?";
		ResultSet resultSet = null;
    	List<OrderLine> list = new ArrayList<OrderLine>();
    	PreparedStatement preparedStatement = null;
    	try(Connection connection = DBUtility.getConnection()) {
    		preparedStatement = connection.prepareStatement(QUERY);
    		resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product();
				Order order = new Order();
				OrderLine orderLine = new OrderLine();
				order.setDate(DBUtility.convertFromSQLDateToUTILDate(resultSet.getDate(1)));
				product.setId(resultSet.getInt(2));
				orderLine.setPrice(resultSet.getFloat(3));
				product.setName(resultSet.getString(4));
				product.setPicture(resultSet.getString(5));
				orderLine.setOrder(order);
				orderLine.setProduct(product);
				list.add(orderLine);
			}
		}catch(SQLException exception) {
	   		exception.printStackTrace();
	   	}
	   	finally {
	   		DBUtility.close(preparedStatement,resultSet);
    	}
    	return list;
	}
*/
	public int updateImg(int productId, String image) {
		PreparedStatement preparedStatement = null;
	int status = 0;
	Connection connection = DBUtility.getConnection();
	final String QUERY = "update products set picture = ? where product_id = ?";
	try {
		preparedStatement = connection.prepareStatement(QUERY);
		preparedStatement.setString(1, image);
		preparedStatement.setInt(2, productId);
		status = preparedStatement.executeUpdate();
	}catch(SQLException exception) {
		exception.printStackTrace();
	}finally {
		DBUtility.close(preparedStatement);
	}
	return status;

	}
}