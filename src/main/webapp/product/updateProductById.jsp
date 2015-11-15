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
		            <li><a href="../client/deleteClientByIdData.jsp">Delete client by id</a></li> 
		          </ul>
		        </li>
    		    <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Product<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="addProductData.jsp">Add product</a></li>
		            <li><a href="deleteAllProducts.jsp">Delete all products</a></li>
		            <li><a href="getAllProducts.jsp">Show all products</a></li>
		            <li><a href="updateProductByIdData.jsp">Update product</a></li> 
		            <li><a href="deleteProductByIdData.jsp">Delete product by id</a></li> 
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
	
		<jsp:useBean id="product" class="domain.Product" scope="session" />
		
		<jsp:setProperty name="product" property="*" /> 
		
		<jsp:useBean id="managerProduct" class="service.ProductManager" scope="application" />
		
		<% 
			managerProduct.updateProductById(product);
		%>
		
		<p>Following product has been updated: </p>
		<p>ID: <jsp:getProperty name="product" property="id"></jsp:getProperty></p>
		<p>Product name: <jsp:getProperty name="product" property="productName"></jsp:getProperty></p>
		<p>Price: <jsp:getProperty name="product" property="price"></jsp:getProperty></p>
		<p>Category: <jsp:getProperty name="product" property="category"></jsp:getProperty></p>
		<p>Is avaiable: <jsp:getProperty name="product" property="isAvaiable"></jsp:getProperty></p>
		
	</body>
</html>