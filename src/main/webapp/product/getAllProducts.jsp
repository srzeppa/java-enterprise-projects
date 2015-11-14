<%@page import="domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
	
	<jsp:useBean id="manager" class="service.ProductManager" scope="application" />
		<table border="1" style="width:100%">
		<tr style="color:red">
			<td>Product name</td>
			<td>Price </td>
			<td>Category</td>
			<td>Is avaiable</td>
		</tr>
			<% 
			  for (Product product : manager.getAllProducts()) {
				  out.println("<tr>");
				  out.println("<td>" + product.getProductName() + "</td><td>" + product.getPrice() + "</td><td>" + product.getCategory() + "</td><td>" + product.getIsAvaiable() + "</td>");
				  out.println("</tr>");
			  }
			%>
		</table>
	</body>
</html>