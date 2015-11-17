<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<title>Add new client</title>
</head>
<body>

<jsp:useBean id="storageClient" class="service.ClientManager" scope="application" />
<jsp:useBean id="client" class="domain.Client" scope="session" />


<form action="getClientByLastname.jsp">

  Name you are searching for :<input type="text" name="lastname" value="" /><br />
 
  <input type="submit" value=" OK ">
  <input type="hidden" name="lastname" value="${lastname}"> 
</form>

</body>
</html>