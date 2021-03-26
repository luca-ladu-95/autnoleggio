<%@page import="utilita.UtilPath"%>
<%@page import="java.util.List"%>
<%@page import="model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuova auto</title>
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

	<%
	List<Categoria> categorie = (List<Categoria>) request.getAttribute("Categorie");

	%>
	
	
	<nav class=" border-0 navbar navbar-inverse navbar-dark ">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a  href="HomeAdminServlet">Home</a></li>
				<li><a href="#">Inserisci nuova auto</a></li>
				<li><a href="NuovaCategoriaServlet">Inserisci nuova categoria</a></li>
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
			<form action="<%=UtilPath.REGISTRA_NUOVA_AUTO_SERVLET%>" method="post">
				<h2 class="text-center">Nuova auto</h2>

				<div class="form-group">
					<input type="text" class="form-control" placeholder="Marca"
						name="Marca" required="required">
				</div>

				<div class="form-group">
					<input type="text" class="form-control" placeholder="Modello"
						name="Modello" required="required">
				</div>


				<div class="form-group">
					<input type="text" class="form-control" placeholder="Colore"
						name="Colore" required="required">
				</div>
				
				
			
				
				<div class="form-group">

					
					<select class="form-select form-control" name="Categoria" required="required" >

					<%for (Categoria cat : categorie) { %>
					
					<option value="<%=cat.getPERSONAL_ID()%>"><%=cat.getNome()%></option>
					
					<%} %>

					</select>



				</div>
				
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