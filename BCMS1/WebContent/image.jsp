<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "./BCMSController" method = "Post" enctype = "multipart/form-data">
<input type = "text" name = "pId"   placeholder = "Enter productId">
<input type = "file" name = "myFile"  value = "myFile">
<img src = "C:\workspace\BCMS1\WebContent\products\4_welcome.jpg" height = "200" width = "200">
<input type = "submit" value = "submit">

</body>
</html>