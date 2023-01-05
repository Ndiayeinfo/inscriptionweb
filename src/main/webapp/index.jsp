<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String message = "";
if (request.getAttribute("message") != null) {
	message = (String) request.getAttribute("message");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Connexion</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">
</head>
<body>
	<div class="container col-md-6 my-5">
		<%
		if (message != null || message != "") {
		%>
		<div>
			<label style="color: red;"><%=message%></label>
		</div class="mb-3">
		<%
		}
		%>
		<form action="loginServlet" method="post">
			<div class="container">
				<div class="mb-3">
					<label for="username" class="form-label">Nom d'utilisateur</label>
					<input type="text" class="form-control" id="username"
						aria-describedby="usernameHelp" autocomplete="off" name="username">
				</div>
				<div class="mb-3">
					<label for="exampleInputPassword1" class="form-label">Mot
						de passe</label> <input type="password" class="form-control"
						id="exampleInputPassword1" autocomplete="off" name="password">
				</div>
				<button type="submit" class="btn btn-primary">Se connecter</button>
				<script type="text/javascript"
					src="<%=request.getContextPath()%>/ressources/js/bootstrap.min.js">
					
				</script>
			</div>
		</form>
	</div>
</body>
</html>