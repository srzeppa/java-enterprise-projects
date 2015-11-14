<%@page import="domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
	</head>
	<body>
	
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <p class="navbar-brand">Sports shop</p>
		    </div>
		    <div>
		      <ul class="nav navbar-nav">
		        <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Client<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="../client/addClientData.jsp">Add client</a></li>
		            <li><a href="../client/deleteAllClients.jsp">Delete all clients</a></li>
		            <li><a href="../client/getAllClients.jsp">Show all clients</a></li>
		            <li><a href="../client/updateClientByIdData.jsp">Update client</a></li> 
		            <li><a href="#">Delete client by id</a></li> 
		          </ul>
		        </li>
    		    <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Product<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="addProductData.jsp">Add product</a></li>
		            <li><a href="deleteAllProducts.jsp">Delete all products</a></li>
		            <li><a href="getAllProducts.jsp">Show all products</a></li>
		            <li><a href="updateProductByIdData.jsp">Update product</a></li> 
		            <li><a href="#">Delete product by id</a></li> 
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Purchase<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="../purchase/addPurchaseData.jsp">Add purchase</a></li>
		            <li><a href="../purchase/deleteAllPurchases.jsp">Delete all purchases</a></li>
		            <li><a href="../purchase/getAllPurchases.jsp">Show all purchases</a></li>
		     <!--        <li><a href="purchase/updatePurchaseByIdData.jsp">Update purchase</a></li> 
		            <li><a href="#">Delete purchase by id</a></li>  -->
		          </ul>
		        </li> 
		      </ul>
		    </div>
		  </div>
		</nav>
	
	<jsp:useBean id="managerProduct" class="service.ProductManager" scope="application" />
		<table border="1" style="width:100%">
		<tr style="color:red">
			<td>Product name</td>
			<td>Price </td>
			<td>Category</td>
			<td>Is avaiable</td>
		</tr>
			<% 
				for (Product product : managerProduct.getAllProducts()) {
					out.println("<tr>");
					out.println("<td>" + product.getProductName() + "</td><td>" + product.getPrice() + "</td><td>" + product.getCategory() + "</td><td>" + product.getIsAvaiable() + "</td>");
					out.println("</tr>");
				}
				out.close();
			%>
		</table>
	</body>
</html>