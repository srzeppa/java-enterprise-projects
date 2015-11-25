<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page import="domain.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='../webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
		        <script>
            function confirmGo(m,u) {
                if ( confirm(m) ) {
                    window.location = u;
                }
            }
        </script>
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
		          </ul>
		        </li> 
		      </ul>
		    </div>
		  </div>
		</nav>
		
	<jsp:useBean id="managerClient" class="service.ClientManager" scope="application" />
		<table border="1" style="width:100%">
		<tr style="color:red">
			<td>ID</td>
			<td>First name</td>
			<td>Last name</td>
			<td>Pesel</td>
			<td>Delete</td>
		</tr>
		
<%-- 		<% 
			  for (Client client : manager.getAllClients()) {
				  out.println("<tr>");
				  out.println("<td>" + client.getId() + "</td><td>" + client.getFirstname() + "</td><td>" + client.getLastname() + "</td><td>" + client.getPesel() + "</td>");
				  out.println("</tr>");
			  }
			  out.close();
			%>  --%>
		<c:forEach var="client" items="${managerClient.allClients}">
		   <tr><td><c:out value="${client.id}"/></td><td><c:out value="${client.firstname}"/></td><td><c:out value="${client.lastname}"/></td><td><c:out value="${client.pesel}"/></td><td><a class="btn btn-danger" href="javascript:confirmGo('Sure to delete this record?','deleteClientById.jsp?id=<c:out value="${client.id}"/>')">Delete</a></td></tr>
		</c:forEach>
			
		</table>
		
		
	</body>
</html>