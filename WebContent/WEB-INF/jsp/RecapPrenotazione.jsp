<%@page import="model.Noleggio"%>
<%@page import="utilita.UtilPath"%>
<%@page import="java.sql.Date"%>
<%@page import="model.Utente"%>
<%@page import="model.Automobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recap</title>
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
	
	Noleggio noleggio = (Noleggio) request.getAttribute("Noleggio");
	Utente utente = (Utente) request.getSession().getAttribute("Utente");
	
	%>


	<div class="container">

		<div class="row" style="padding: 15px">
		
		
		

			<div class="login-form">
				
					<h2 class="text-center form-group alert alert-success">Noleggio effettuato con successo</h2>

					<div class="form-group">
						<label>Marca</label> <input type="text" class="form-control"
							placeholder="<%=noleggio.getAutomobile().getMarca() %>" readonly>
					</div>

					<div class="form-group">
						<label>Modello</label> <input type="text" class="form-control"
							placeholder="<%=noleggio.getAutomobile().getModello() %>" readonly>
					</div>


					<div class="form-group">
						<label>Categoria</label> <input type="text" class="form-control"
							placeholder="<%=noleggio.getAutomobile().getCategoria().getNome() %>" readonly>
					</div>
					<div class="form-group">
						<label>Targa</label> <input type="text" class="form-control"
							placeholder="<%=noleggio.getAutomobile().getTarga() %>" readonly>
					</div>

					<div class="form-group">
						<label>Data inizio noleggio</label> 
						<input type="text" class="form-control"
							placeholder="<%=noleggio.getDataInizio() %>" readonly>
					</div>

					<div class="form-group ">
						<label>Data fine noleggio</label> 
						<input type="text" class="form-control"
							placeholder="<%=noleggio.getDataFine() %>" readonly>

					</div>
					
					<div class="form-group ">
						<label>Costo totale</label> 
						<input type="text" class="form-control"
							placeholder="<%=noleggio.calcolaPrezzoNoleggio() %>" readonly>

					</div>
				
					


					<div class="form-group">
						<a href="LeTuePrenotazioniServlet" type="submit" class="btn btn-primary btn-block">Home</a>
					</div>

			


			</div>

		</div>
		</div>

		
</body>
</html>