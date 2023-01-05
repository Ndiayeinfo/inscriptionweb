<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un utilisateur</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<header class="my-5">
			<%@include file="/WEB-INF/vue/header.jsp"%>
		</header>
		<section>
			<form method="post" action="ajout.us">
				<div class="mb-3">
					<label for="email" class="form-label">Email address</label> <input
						type="email" class="form-control" id="email"
						aria-describedby="emailHelp" autocomplete="off" name="email">
					<div id="emailHelp" class="form-text">Nous ne partagerons
						jamais votre adresse électronique avec qui que ce soit.</div>
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Mot
						de passe</label> <input type="password" class="form-control"
						id="exampleInputPassword1" autocomplete="off" name="password">
				</div>
				<button type="submit" class="btn btn-primary">Enregistrer</button>
			</form>
		</section>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
			
		</script>
	</div>
</body>
</html>