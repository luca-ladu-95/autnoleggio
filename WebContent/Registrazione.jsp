<%@page import="utilita.UtilPath"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet" href="css/style.css">
</head>
<body>



	<div class="container">

		<div class="login-form">
			<form action="<%=UtilPath.REGISTRAZIONE_SERVLET%>" method="post">
				<h2 class="text-center">Registrazione</h2>

				<div class="form-group">
					<input type="text" class="form-control" placeholder="Nome"
						name="Nome" required="required">
				</div>

				<div class="form-group">
					<input type="text" class="form-control" placeholder="Cognome"
						name="Cognome" required="required">
				</div>


				<div class="form-group">
					<input type="text" class="form-control" placeholder="Username"
						name="Username" required="required">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="Password"
						name="Password" required="required">
				</div>

				<div class="form-group ">

					<input type="date" class="form-control" required="required"
					placeholder="Data di nascita"
						id="birthday" name="DataDiNascita">


				</div>


				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">Invio</button>
				</div>

			</form>
			<p class="text-center">
				<a href="Login.jsp">Login</a>
			</p>
		</div>







	</div>





</body>
</html>