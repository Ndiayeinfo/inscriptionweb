<%@page import="web.model.InscriptionModel"%>
<%@page import="metier.entities.Inscription"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="metier.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">

<%
InscriptionModel inscriptions = (InscriptionModel) request.getAttribute("inscriptions");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Gestion des inscriptions</title>
</head>
<body class="container">
	<header class="my-5">
		<%@include file="/WEB-INF/vue/header.jsp"%>
	</header>
	<section>
		<div>
			<div>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Date</th>
						<th>Classe</th>
						<th>Utilisateur</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<%
					if (inscriptions.getInscriptions().size() == 0) {
					%>
					<span style="color: red;">Il n'y a aucun inscrit dans la
						base</span>
					<%
					} else {
					for (Inscription inscription : inscriptions.getInscriptions()) {
					%>
					<tr>
						<td><%=inscription.getId()%></td>
						<td><%=inscription.getDate()%></td>
						<td><%=inscription.getClasse()%></td>
						<td><%=inscription.getUser().getEmail()%></td>
						<td><a href="update.is?id=<%=inscription.getId()%>"><img
								src="<%=request.getContextPath()%>/ressources/images/pen.png"
								style="height: 25px;"></a></td>
						<td><a onclick="return confirm('Etes-vous sure de vouloir supprimer ?')" href="delete.is?id=<%=inscription.getId()%>"><img
								src="<%=request.getContextPath()%>/ressources/images/trash.png"
								style="height: 25px;"></a></td>
					</tr>
					<%
					}
					}
					%>
				</table>
			</div>
	</section>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
		
	</script>
</body>
</html>