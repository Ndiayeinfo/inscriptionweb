<%@page import="metier.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">

<%
UserModel user = (UserModel) request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mise à jour d'un utilisateur</title>
</head>
<body>
	<div class="container">
		<header class="my-5">
			<%@include file="/WEB-INF/vue/header.jsp"%>
		</header>
		<section>
			<form action="modif.us" method="post">
				<div class="mb-3">
					<label for="id" class="form-label">ID Utilisateur</label> <input
						type="text" class="form-control" id="id"
						aria-describedby="emailHelp" autocomplete="off" name="id"
						disabled="disabled" value="<%=user.getId()%>">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">ID Utilisateur</label> <input
						type="hidden" class="form-control" id="id"
						aria-describedby="emailHelp" autocomplete="off" name="id"
						value="<%=user.getId()%>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">E-mail</label> <input
						type="email" class="form-control" id="email" autocomplete="off"
						name="email" value="<%=user.getEmail()%>">
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">Mot de passe</label> <input
						type="password" class="form-control" id="password"
						autocomplete="off" name="password" value="<%=user.getPassword()%>" />
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