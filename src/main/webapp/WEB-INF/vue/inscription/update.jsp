<%@page import="web.model.InscriptionModel"%>
<%@page import="metier.entities.Inscription"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">

<%
InscriptionModel inscription = (InscriptionModel) request.getAttribute("inscription");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update user</title>
</head>
<body>
	<div class="container">
		<header class="my-5">
			<%@include file="/WEB-INF/vue/header.jsp"%>
		</header>
		<section>
			<form action="modif.is" method="post">
				<div class="mb-3">
					<label for="id" class="form-label">Identifiant</label> <input
						type="text" class="form-control" id="id"
						aria-describedby="emailHelp" autocomplete="off" name="id"
						disabled="disabled" value="<%=inscription.getId()%>">
				</div>
				<div class="mb-3">
					<input type="hidden" class="form-control" id="id"
						aria-describedby="emailHelp" autocomplete="off" name="id"
						value="<%=inscription.getId()%>">
				</div>
				<div class="mb-3">
					<label for="date" class="form-label">Date</label> <input
						type="date" class="form-control" id="date" autocomplete="off"
						name="date" value="<%=inscription.getDate()%>">
				</div>
				<div class="mb-3">
					<label for="classe" class="form-label">Classe</label> <input
						type="text" class="form-control" id="classe" autocomplete="off"
						name="classe" value="<%=inscription.getClasse()%>">
				</div>
				<div class="mb-3">
					<label for="iduser" class="form-label">ID Utilisateur</label> <input
						type="text" class="form-control" id="iduser" autocomplete="off"
						name="iduser" value="<%=inscription.getUser().getId()%>" />
				</div>
				<button type="submit" class="btn btn-primary">Mettre à jour</button>
			</form>
		</section>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
			
		</script>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
		
	</script>
</body>
</html>