<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Noleggio"%>
<%@page import="java.util.List"%>
<%@page import="model.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Le tue prenotazioni</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<%
	Utente utente = (Utente) request.getSession().getAttribute("Utente");
	List<Noleggio> noleggi = (List<Noleggio>) request.getAttribute("Noleggi");
	%>
	<nav class=" border-0 navbar navbar-inverse navbar-dark ">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a
					href="HomePageServlet">Home</a></li>
				<li class="active"><a href="#">I tuoi noleggi</a></li>
				<li><a href="#">Simulatore</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">


		<div class="row">

			<%
			for (Noleggio n : noleggi) {
			%>

			<div class=" col-sm-12 col-md-4 col-lg-3 " style="margin-bottom:10px ">


				<div class="card bg-light mb-3" style="max-width: 25rem;">
					<div class="card-header">
						Noleggio n:
						<%=n.getPERSONAL_ID()%></div>
					<div class="card-body">
						<h5 class="card-title">
							Auto : <%=n.getAutomobile().getMarca() %> 
							<%=n.getAutomobile().getModello()%></h5>
						<div class="form-group">
							<label>Inzio</label> <input type="text" class="form-control"
								placeholder="<%=n.getDataInizio()%>" readonly>
						</div>
						
						<% if(n.getDataFine().before(Date.valueOf(LocalDate.now()))){ %>
						
						<div class="form-group">
							<label>Noleggio finito</label> <input type="text" class="form-control alert-danger"
								placeholder="<%=n.getDataFine()%>" readonly>
						</div>
						
						<%}else{ %>

						<div class="form-group">
							<label>Noleggio in corso</label> <input type="text" class="form-control alert-success"
								placeholder="<%=n.getDataFine()%>" readonly>
						</div>
						
						<%} %>
						<div class="form-group">
						<label>Spesa totale</label> <input type="text" class="form-control"
							placeholder="<%=n.calcolaPrezzoNoleggio()%>" readonly>
					</div>
					</div>
				</div>


			</div>





			<%
			}
			%>


		</div>


	</div>


</body>
</html>