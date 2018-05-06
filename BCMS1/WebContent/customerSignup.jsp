<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SignUp</title>
<link href="./Resources/signupform.css" rel="stylesheet" type="text/css" />

</head>
<h2>
<%if(request.getAttribute("registrationStatus:")==null)
	out.println();
else
	out.println("<center>"+request.getAttribute("registrationStatus:")+"</center>");
	%>
</h2>

<body>
<div class="simple-form">
<form id="customerSignup"action="./BCMSController" method="post">
<br>
<style>
h1{text-align:center;color:white}
</style>
<h1>Customer SignUp </h1><br><br>
			<input type = "text" name = "id" id = "button" placeholder = "Enter CustomerId"><br><br>
			<input type="text" name="first_name" id="button" placeholder="Enter FirstName"><br><br>
			<input type="text" name="last_name" id="button" placeholder="Enter LastName"><br><br>
			<input type="text" name="dob" id="button" placeholder="Enter Date Of Birth"><br><br>
			<input type="text" name="gender" id="button" placeholder="Gender"><br><br>
			<input type="email" name="email_id" id="button" placeholder="Enter Email"><br><br>
			<input type="password" name="password" id="button" placeholder="Enter password"><br><br>
			<input type="text" name="phoneno" id="phone" placeholder="Enter ContactNo"><br><br>
			<input type="text" name="companyId" id="button" placeholder="Enter workingcompany Id"><br><br>
			<input type="text" name="houseNo" id="button" placeholder="Enter House Number"><br><br>
			<input type="text" name="location" id="button" placeholder="Enter Location"><br><br>
			<input type="text" name="city" id="button" placeholder="Enter city"><br><br>
			<input type="text" name="state" id="button" placeholder="Enter State"><br><br>
			<input type="text" name="country" id="button" placeholder="Enter country"><br><br>
			<input type="text" name="pincode" id="button" placeholder="Enter pincode"><br><br>
			<input type="submit" value="Register"id="butt">	
			<input type = "hidden" name = "action" value = "customerSignup"/>	

</form>
</div>
</body>
</html>