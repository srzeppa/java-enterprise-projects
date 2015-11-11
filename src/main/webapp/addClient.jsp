<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="client" class="domain.Client" scope="session" />

<jsp:setProperty name="client" property="*" /> 

<jsp:useBean id="manager" class="service.ClientManager" scope="application" />

<% 
  manager.addClient(client);
%>

<p>Following client has been added to storage: </p>
<p>First name: ${client.firstname} </p>
<p>Last name: ${client.lastname} </p>
<p>Pesel: <jsp:getProperty name="client" property="pesel"></jsp:getProperty> </p>
<p>
  <a href="getAllClients.jsp">Show all clients</a>
</p>
</body>
</html>