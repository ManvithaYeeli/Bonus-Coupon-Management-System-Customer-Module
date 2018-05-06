<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!!!</title>
<h1>[BCMS]</h1><br>
    <p id = id>Customer :  ${cuser.name}</p>

<style>
body{
background-image:url("./images/InShot_20180501_110008289.jpg");
background-size:cover;
font-family:verdana;
font-size:15px;
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
</style>
</head>
<body>
<div class="navbar">
<ul>
<li><a href ="./BCMSController?action=customerProfile">PROFILE </a></li>
<li><a href ="./BCMSController?action=products">PRODUCTS </a></li>
<li><a href ="./BCMSController?action=order">ORDERS</a></li>
<li><a href ="./BCMSController?action=orderLine">ORDERLINE </a></li>
<li><a href ="#">COUPONS</a></li>
<li><a href ="#">LOGOUT</a></li>
</ul>

</div>
</body>
</html>