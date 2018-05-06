<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<link href="./Resources/resources.css" rel="stylesheet" type="text/css">    
</head>
<body>
<div id = 'header'>
    <h1>[BCMS]</h1><br>
    <p id = id>Customer : ${cuser.name} </p>
    <div class="navbar">
     <a href="#home">Logout</a>
    <a href="./BCMSController?action=adViewCustomer">Coupons</a>
    <a href="./BCMSController?action=orderLine">Order Line</a>
     <a href="./BCMSController?action=adViewCustomer">Orders</a>
     <a href="./BCMSController?action=products">Products</a>
     <a href="./BCMSController?action=customerProfile">Profile</a>
                      
</div>
    
</div>

