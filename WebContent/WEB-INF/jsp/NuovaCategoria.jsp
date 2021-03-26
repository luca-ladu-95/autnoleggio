<%@page import="utilita.UtilPath"%>
<%@page import="java.util.List"%>
<%@page import="model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuova categoira</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>
<body>

	<nav class=" border-0 navbar navbar-inverse navbar-dark ">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a  href="HomeAdminServlet">Home</a></li>
				<li><a href="NuovaAutoServlet">Inserisci nuova auto</a></li>
				<li><a class="active" href="#">Inserisci nuova categoria</a></li>
				<li><a href="GarageServlet">Garage</a></li>
				<li><a href="ListaUtentiServlet">Clienti</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">

		<div class="login-form">
			<form action="RegistraNuovaCategoria" method="post">
				<h2 class="text-center">Nuova categoria</h2>

				<div class="form-group">
					<input type="text" class="form-control" placeholder="Nome"
						name="Nome" required="required">
				</div>

				<div class="form-group">
					<input type="number" min="0" class="form-control" placeholder="Prezzo Giornaliero"
						name="PrezzoGG" required="required">
				</div>


				<div class="form-group">
					<input type="number" min="0" class="form-control" placeholder="Prezzo Settimanale"
						name="PrezzoSS" required="required">
				</div>
				
				
				
				<div class="form-group">
					<input type="number" min="0" class="form-control" placeholder="Prezzo Mensile"
						name="PrezzoMM" required="required">
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
					<button type="submit" class="btn btn-primary btn-block">Invio</button>
				</div>

			</form>

		</div>
</body>
</html>