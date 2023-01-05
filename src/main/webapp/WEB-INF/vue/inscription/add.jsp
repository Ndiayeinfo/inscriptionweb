<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un user</title>
</head>
<body>
	<div class="container">
		<header class="my-5">
			<%@include file="/WEB-INF/vue/header.jsp"%>
		</header>
		<section>
			<form method="post" action="ajout.is">
				<div class="mb-3">
					<label for="date" class="form-label">Date</label> <input
						type="date" class="form-control" id="date"
						aria-describedby="dateHelp" autocomplete="off" name="date">
				</div>
				<div class="mb-3">
					<label for="classe" class="form-label">Classe</label> <input
						type="text" class="form-control" id="classe" autocomplete="off"
						name="classe">
				</div>
				<div class="mb-3">
					<label for="iduser" class="form-label">ID Utilisateur</label> <input
						type="text" class="form-control" id="iduser" autocomplete="off"
						name="iduser">
				</div>
				<button type="submit" class="btn btn-primary">Inscrire</button>
			</form>
		</section>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
			
		</script>
	</div>
</body>
</html>