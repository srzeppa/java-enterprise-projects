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
		<jsp:useBean id="client" class="domain.Client" scope="session" />
		
		<jsp:setProperty name="client" property="*" /> 
		
		<jsp:useBean id="manager" class="service.ClientManager" scope="application" />
		
		<% 
			manager.deleteAllClients();
		%>
		
		<p>Database is clear</p>
		<p>
		  <a href="index.jsp">INDEX</a>
		</p>
	</body>
</html>