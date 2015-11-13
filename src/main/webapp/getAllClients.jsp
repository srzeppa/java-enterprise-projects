<%@page import="domain.Client"%>
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
		            <li><a href="#">Update client</a></li> 
		            <li><a href="#">Delete client by id</a></li> 
		          </ul>
		        </li>
		        <li><a href="#">Product</a></li> 
		        <li><a href="#">Purchase</a></li> 
		      </ul>
		    </div>
		  </div>
		</nav>
	
	<jsp:useBean id="manager" class="service.ClientManager" scope="application" />
		<table border="1" style="width:100%">
		<tr style="color:red">
			<td>First name</td>
			<td>Last name</td>
			<td>Pesel</td>
		</tr>
			<% 
			  for (Client client : manager.getAllClients()) {
				  out.println("<tr>");
				  out.println("<td>" + client.getFirstname() + "</td><td>" + client.getLastname() + "</td><td>" + client.getPesel() + "</td>");
				  out.println("</tr>");
			  }
			%>
		</table>
	</body>
</html>