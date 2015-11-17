<%@page import="domain.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storageClient" class="service.ClientManager" scope="application" />

<%	
	int countFound = 0;
	int countNotFound = 0;
	String lastname = request.getParameter("lastname");
  	for (Client client : storageClient.getAllClients()) {
	  
	  if(client.getFirstname().equals(lastname)){
		  out.println("<p>First name: " + client.getFirstname() + " ; Last name: " + client.getLastname() + "</p>" + "<p>Pesel " + client.getPesel()+ "</p>");
		  countFound++;
	  }
  	}
	  if(countFound==0){
		  out.println("<p>Unfortunatly there is no match in database for: "+lastname+"</p>");
	  }
		
%>
</body>
</html>