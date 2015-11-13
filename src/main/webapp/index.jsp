<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Sport shop</title>
    </head>
    <body>
<!--         <h2>Sport shop</h2>
        <p><a href="addClientData.jsp">Add client</a></p>
        <p><a href="deleteAllClients.jsp">Delete all clients</a></p>
        <p><a href="getAllClients.jsp">Show all clients</a></p>
        <p><a href="#">Update client</a></p>
        <p><a href="#">Delete client by id</a></p> -->
        
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
    </body>
</html>
