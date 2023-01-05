<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String message = (String) request.getAttribute("message");
%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/style.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<div class="form">
		<h2>Formulaire de connexion</h2>
		<%
		if (message != null || message != "") {
		%>
		<span style="color: red;"><%=message%></span>
		<%
		}
		%>
		<form action="loginServlet" method="post">
			<label>Username</label> <input type="text" name="username"
				autocomplete="off" /> <label>Password</label> <input type="text"
				name="password" autocomplete="off" /> <input type="submit"
				value="Se Connecter" />
		</form>
	</div>
</body>
</html>