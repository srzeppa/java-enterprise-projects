<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="manager" class="service.ClientManager" scope="application" />
<jsp:useBean id="client" class="domain.Client" scope="session" />

<form action="addClient.jsp">

  First name :<input type="text" name="firstname" value="${client.firstname}" /><br />
  Last name :<input type="text"  name="lastname" value="${client.lastname}" /><br />
  Pesel:<input type="text"  name="pesel" value="${client.pesel}" /><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>