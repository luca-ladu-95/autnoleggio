
<%@page import="utilita.UtilPath"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet" href="css/style.css">
</head>
<body>


	<div class="container">
	


		<div class="login-form">
			<form action="<%=UtilPath.LOGIN_SERVLET%>" method="post">
				<h2 class="text-center">Autonoleggio</h2>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						name="Username"
						required="required">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="Password"
						required="required">
				</div>
				
					<%
					String msg = (String) request.getAttribute("errore");
					if (msg != null) {
					%>
					<div class="form-group alert alert-danger ">
						<p class="error"><%=msg%></p>
					</div>
					<%
					}
					%>
					
					<%
					String msg2 = (String) request.getAttribute("successo");
					if (msg2 != null) {
					%>
					<div class="form-group alert alert-success ">
						<p class="error"><%=msg2%></p>
					</div>
					<%
					}
					%>
				
				
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">Log
						in</button>
				</div>
				
			</form>
			<p class="text-center">
				<a href="Registrazione.jsp">Crea un Account</a>
			</p>
		</div>







	</div>
	




</body>
</html>