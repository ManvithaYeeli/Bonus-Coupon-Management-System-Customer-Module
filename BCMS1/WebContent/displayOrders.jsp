<%@include file="custHeader.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <title> Products</title>
        <style>
        .row :: after {
        	content:"";
        	margin : auto;
        	clear:both;
        	display:table;
        }
        .column {
        	float : left;
        	width:25%;
        	padding:5px;
        }
            table,
            th,
            td {
                width: 100%;
                margin: auto;
                border: 1px solid white;
                border-collapse: collapse;
                text-align: center;
                font-size: 20px;
                table-layout: fixed;
                background: black;
                opacity: 0.5;
                color: white;
                margin-top: 120px;
            }
        </style>
    </head>
    

    <body>
      	<table>
      	<tr>
    		<td>Order ID</td>
    		<td>Product Name</td>
    		<td>Product Price</td>
    		<td>Product Quantity</td>
    		<td>Product Picture</td>
    		</tr>
    		<tr>
            <c:forEach items="${placeOrder}" var="placeOrder">
  
            		<div class = "row">
            			<div class = "column">
            			 			
                      <td>${placeOrder.order.id}</td><br>
                 <td>${placeOrder.product.name}</td><br>
                 <td>${placeOrder.quantity}</td><br>
                 <td>${placeOrder.price}</td><br>
               <td><img src ="./products/${placeOrder.product.picture}"   width = "25px" height = "25px"></td><br>
                    </div>
					</div>
					</c:forEach>
					</tr>
				</table>
    </body>

    </html>
    