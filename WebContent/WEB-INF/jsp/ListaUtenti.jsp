<%@page import="model.Utente"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista utenti</title>


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
</head>
<body>


	<%
	List<Utente> utenti = (List<Utente>) request.getAttribute("Utenti");
	String ruolo;
	%>



	<nav class=" border-0 navbar navbar-inverse navbar-dark ">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a  href="HomeAdminServlet">Home</a></li>
				<li><a href="NuovaAutoServlet">Inserisci nuova auto</a></li>
				<li><a href="NuovaCategoriaServlet">Inserisci nuova categoria</a></li>
				<li><a href="GarageServlet">Garage</a></li>
				<li><a href="#">Clienti</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ">
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">


		<table class="table table-striped table-hover">
			<thead class="bg-primary">
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Data di nascita</th>
					<th>Ruolo</th>
					<th>Username</th>
				</tr>
			</thead>
			<tbody>
			
			<%for(int i=0 ; i<utenti.size() ; i++) {%>
			
				<tr>
					<td><%=i%></td>
					<td><%=utenti.get(i).getNome() %></td>
					<td><%=utenti.get(i).getCognome() %></td>
					<td><%=utenti.get(i).getDataDiNascita() %></td>
					<% if(utenti.get(i).getUsername().equals("admin")){
					 ruolo = "admin";
					}else{
						ruolo = "cliente";
					} %>
					<td><%=ruolo%></td>
					<td><%=utenti.get(i).getUsername()%></td>
				</tr>
				
			<%} %>
				
			</tbody>
		</table>

	</div>







</body>
</html>