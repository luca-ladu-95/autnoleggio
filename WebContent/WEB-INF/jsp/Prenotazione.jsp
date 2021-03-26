<%@page import="utilita.UtilPath"%>
<%@page import="model.Utente"%>
<%@page import="model.Automobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prenotazione</title>
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
	Automobile auto = (Automobile) request.getAttribute("Auto");
	Utente utente = (Utente) request.getSession().getAttribute("Utente");
	%>




	<div class="container">

		<div class="row" style="padding: 15px">




			<div class="login-form">
				<form action="<%=UtilPath.REGISTRA_PRENOTAZIONE_SERVLET%>"
					method="post">
					<h2 class="text-center">Riepilogo</h2>

					<div class="form-group">
						<label>Marca</label> <input type="text" class="form-control"
							placeholder="<%=auto.getMarca()%>" readonly>
					</div>

					<div class="form-group">
						<label>Modello</label> <input type="text" class="form-control"
							placeholder="<%=auto.getModello()%>" readonly>
					</div>


					<div class="form-group">
						<label>Categoria</label> <input type="text" class="form-control"
							placeholder="<%=auto.getCategoria().getNome()%>" readonly>
					</div>
					<div class="form-group">
						<label>Targa</label> <input type="text" class="form-control"
							placeholder="<%=auto.getTarga()%>" readonly>
					</div>

					<div class="form-group">
						<label>Data inizio noleggio</label> <input type="date"
							class="form-control" required="required" name="DataDiInzio">
					</div>

					<div class="form-group ">
						<label>Data fine noleggio</label> <input type="date"
							class="form-control" required="required" name="DataDiFine">


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



					<input type="hidden" name="idAuto" value=<%=auto.getPERSONAL_ID()%>>
					
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">Invio</button>
					</div>

				</form>


			</div>

		</div>
</body>
</html>