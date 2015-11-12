<%@page import="domain.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
		<title>Insert title here</title>
	</head>
	<body>
	
	<jsp:useBean id="manager" class="service.ClientManager" scope="application" />
		
		<% 
		  for (Client client : manager.getAllClients()) {
			  out.println("<p>First name: " + client.getFirstname() + "; Last name: " + client.getLastname() + "; Pesel: " + client.getPesel() + "</p>");
		  }
		%>
		
		<p>
		  <a href="index.jsp">INDEX</a>
		</p>
	</body>
</html>