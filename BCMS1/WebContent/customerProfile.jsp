<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Customer Profile</title>
<style>
body{

background:url(./images/pic.jpg) no-repeat center fixed;
background-size:cover;
}
.navbar{
text-align:center;
width:100%;
background:blue;
opacity:0.5;
}
.navbar ul{
margin:0;
padding:0;
list-style:none;
position:relative;

}
.navbar ul li a{
display:block;
padding:25px;
color:white;
text-decoration:none;
width:100px;

}
.navbar ul:after{
content:"";clear:both;
display:block;

}
.navbar ul li{
float:left;
listy-style:none;

}
.navbar ul ul{
display:none;

}
.navbar ul li:hover > ul{
display:block;

}
.navbar ul li:hover {
	background:black;
	transition:0.9s;
}
.navbar ul li:hover a{
color:white;
}
.navbar ul ul{
background:black;
padding:0;
margin:0;
position:absolute;top:100%;

}
.navbar ul ul li {
float:none;
position:relative;

}
.navbar ul ul li a{
padding:25px;
color:white;
width:300px;
text-align:left;
}
.navbar ul ul li a :hover{
background:lightblue;
color:black;
transition:0.9s; 
}

table,th,td{
width:100%;
margin:auto;
border:1px solid white;
border-collapse:collapse;
text-align:center;
font-size:20px;
table-layout:fixed;
background:orange;
opacity:0.9;
color:;
margin-top:120px;
}
</style>
</head>
<body>
<div class="navbar">
<ul>
<li><a href ="./BCMSController?action=customerProfile"">PROFILE </a></li>
<li><a href ="./BCMSController?action=products">PRODUCTS </a></li>
<li><a href ="./BCMSController?action=order">ORDERS</a></li>
<li><a href ="#">ORDERLINE </a></li>
<li><a href ="#">COUPONS</a></li>
<li><a href ="#">LOGOUT</a></li>
</ul>

</div>

<table>
<tr>
<th>Name</th>
<th>CustomerId</th>
<th>Date Of Birth</th>
<th>Phone No</th>
<th>Email Id</th>
<th>Location</th>
</tr>
<tr>
  <td>
                        
                        ${cuser.name}

                            ${cuser.surname}</td>
                        <td>
                            ${cuser.id}</td>
                            <td>
                            ${cuser.dob}</td>
                        <td>
                            ${cuser.phno}
                        </td>
                            <td>
                            ${cuser.email}</td>
                        <td>
                           ${cuser.houseno},
                            ${cuser.location},
                            ${cuser.city},
                            ${cuser.state},
                            ${cuser.country},
                            ${cuser.pincode}</td>

</tr>
</table>

</body>
</html>