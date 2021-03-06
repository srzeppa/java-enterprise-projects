<%@page import="domain.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		            <li><a href="addClientData.jsp">Add client</a></li>
		            <li><a href="deleteAllClients.jsp">Delete all clients</a></li>
		            <li><a href="getAllClients.jsp">Show all clients</a></li>
		            <li><a href="updateClientByIdData.jsp">Update client</a></li> 
		            <li><a href="deleteClientByIdData.jsp">Delete client by id</a></li> 
		            <li><a href="getClientByLastnameData.jsp">Show client by lastname</a></li>
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
		            <li><a href="../purchase/addPurchaseData.jsp">Add purchase</a></li>
		            <li><a href="../purchase/deleteAllPurchases.jsp">Delete all purchases</a></li>
		            <li><a href="../purchase/getAllPurchases.jsp">Show all purchases</a></li>
		     <!--        <li><a href="../purchase/updatePurchaseByIdData.jsp">Update purchase</a></li> 
		            <li><a href="#">Delete purchase by id</a></li>  -->
		          </ul>
		        </li> 
		      </ul>
		    </div>
		  </div>
		</nav>

<jsp:useBean id="storageClient" class="service.ClientManager" scope="application" />
<table border="1" style="width:100%">
<tr style="color:red">
	<td>First name</td>
	<td>Last name</td>
	<td>Pesel</td>
</tr>
<%	
	int countFound = 0;
	int countNotFound = 0;
	String lastname = request.getParameter("lastname");
  	for (Client client : storageClient.getAllClients()) {
	  
	  if(client.getLastname().equals(lastname)){
		  out.println("<tr>");
		  out.println("<td>" + client.getFirstname() + "</td><td>" + client.getLastname() + "</td><td>" + client.getPesel() + "</td>");
		  out.println("</tr>");
		  countFound++;
	  }
  	}
	  if(countFound==0){
		  out.println("<p>Unfortunatly there is no match in database for: "+lastname+"</p>");
	  }
	  out.close();
%>
</table>
</body>
</html>