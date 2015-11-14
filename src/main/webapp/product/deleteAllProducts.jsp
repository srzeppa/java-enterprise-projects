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
		<jsp:useBean id="product" class="domain.Product" scope="session" />
		
		<jsp:setProperty name="product" property="*" /> 
		
		<jsp:useBean id="manager" class="service.ProductManager" scope="application" />
		
		<% 
			manager.deleteAllProducts();
		%>
		
		<p>Database is clear</p>
	</body>
</html>