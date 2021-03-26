<%@page import="utilita.UtilPath"%>
<%@page import="model.Utente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Automobile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<!-- Latest compiled and minified CSS -->


<title>Home page</title>
<jsp:include page="../../navbar/navbar.jspf" />

<body>


	<%
	Utente utente = (Utente) request.getSession().getAttribute("Utente");

	List<Automobile> automobili = (List<Automobile>) request.getAttribute("Automobili");

	if (automobili == null)
		automobili = new ArrayList<Automobile>();
	%>

	<nav class=" border-0 navbar navbar-inverse navbar-dark ">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a class="" href="HomeAdminServlet">Home</a></li>
				<li><a href="NuovaAutoServlet">Inserisci nuova auto</a></li>
				<li><a href="NuovaCategoriaServlet">Inserisci nuova categoria</a></li>
				<li><a class="active" href="#">Garage</a></li>
				<li><a href="ListaUtentiServlet">Clienti</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>



	<div class="container">







		<div class="row">
			<div class="col-12">
				<div class="text-center">
				
			
				
				
					<form method="post" action="<%=utilita.UtilPath.FILTRA_SERVLET%>">

						<input name="Ricerca" class="form-control border-secondary py-2"
							type="search" value="" placeholder="Ricerca"> 
							<select class="form-select" name="filtro" aria-label="Default select example"
							style="margin-top:5px">
							<option selected>Scegli il filtro</option>
							<option value="Modello">Modello</option>
							<option value="Marca">Marca</option>
							<option value="Colore">Colore</option>
							<option value="Categoria">Categoria</option>

						</select>
						
						<input type="hidden" value="<%=utente.getPERSONAL_ID()%>" name="IdUtente">
						
						<div class="text-center mt-2">
							<button class="btn ricerca" type="submit">
								<i class="fa fa-search">Invio</i>
							</button>
						</div>
					</form>

				</div>
			</div>
		</div>


	</div>


	<br>

	<div class="row " style="padding: 15px">
	
		<% if(automobili.isEmpty()) {%>
		
		<div class="form-group alert alert-danger m-4 text-center">
						<p class="error">Nessuna auto corrispondente alla ricerca</p>
					</div>
		
		<%} %>

		<%
		for (Automobile auto : automobili) {
		%>

		<div class="col-sm-12 col-md-4 col-lg-4 border-1" style="margin-bottom:10px ">

			<div class="card text-center p-3">

				<div class="card-body">
					<h4 class="card-title text-center bold">
						<strong><%=auto.getMarca()%></strong>
					</h4>
					<h4 class="card-title text-center"><%=auto.getModello()%></h4>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Prezzo gg: <%=auto.getCategoria().getPrezzoGiornaliero()%></li>
					<li class="list-group-item">Prezzo set: <%=auto.getCategoria().getPrezzoSettimanale()%></li>
					<li class="list-group-item">Prezzo mm: <%=auto.getCategoria().getPrezzoMensile()%></li>

				</ul>
				
			</div>
		</div>



		<%
		}
		%>
	</div>
	</div>




</body>
</html>