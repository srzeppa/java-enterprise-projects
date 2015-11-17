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
		            <li><a href="../client/getClientByLastnameData.jsp">Show client by lastname</a></li>
		          </ul>
		        </li>
    		    <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Product<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="../product/addProductData.jsp">Add product</a></li>
		            <li><a href="../product/deleteAllProducts.jsp">Delete all products</a></li>
		            <li><a href="../product/getAllProducts.jsp">Show all products</a></li>
		            <li><a href="../product/updateProductByIdData.jsp">Update product</a></li> 
		            <li><a href="../product/deleteProductByIdData.jsp">Delete product by id</a></li> 
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a class="dropdown-toggle" data-toggle="dropdown" href="">Purchase<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="addPurchaseData.jsp">Add purchase</a></li>
		            <li><a href="deleteAllPurchases.jsp">Delete all purchases</a></li>
		            <li><a href="getAllPurchases.jsp">Show all purchases</a></li>
		     <!--        <li><a href="purchase/updatePurchaseByIdData.jsp">Update purchase</a></li> 
		            <li><a href="#">Delete purchase by id</a></li>  -->
		          </ul>
		        </li> 
		      </ul>
		    </div>
		  </div>
		</nav>

<jsp:useBean id="purchaseManager" class="service.PurchaseManager" scope="application" />
<jsp:useBean id="purchase" class="domain.Purchase" scope="session" />

<form action="addPurchase.jsp">

  Price :<input type="text" name="price" value="" /><br />
  Date :<input type="text" name="date" value="" /><br />
  ID Client :<input type="text"  name="idClient" value="" /><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>