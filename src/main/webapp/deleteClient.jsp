<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="idClient" class="domain.Client" scope="session" />

<jsp:setProperty name="idClient" property="*" /> 

<jsp:useBean id="manager" class="service.ClientManager" scope="application" />

<% 
  manager.deleteClientById(idClient);
%>

<p>Following client has been deleted from storage: </p>
<p>First name: ${client.firstname} </p>
<p>Last name: ${client.lastname} </p>
<p>Pesel: <jsp:getProperty name="client" property="pesel"></jsp:getProperty> </p>
<p>
  <a href="getAllClients.jsp">Show all clients</a>
</p>
<p><a href="index.jsp">INDEX</a></p>
</body>
</html>