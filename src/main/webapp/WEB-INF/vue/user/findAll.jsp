<%@page import="metier.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ressources/css/bootstrap.min.css">
<%
UserModel users = (UserModel) request.getAttribute("users");
if (users.equals(null)) {
	users = new UserModel();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Gestion des utilisateurs</title>
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
						<th>Email</th>
						<th>Password</th>
						<th>Modifier</th>
						<th>Supprimer</th>
					</tr>
					<%
					if (users.getUsers().size() == 0) {
					%>
					<span style="color: red;">Il n'y a pas d'utilisateurs dans
						la base</span>
					<%
					} else {
					for (User user : users.getUsers()) {
					%>
					<tr>
						<td><%=user.getId()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getPassword()%></td>
						<td><a href="update.us?id=<%=user.getId()%>"><img
								src="<%=request.getContextPath()%>/ressources/images/pen.png"
								style="height: 25px;""></a></td>
						<td><a
							onclick="return confirm('Etes-vous sure de vouloir supprimer ?')"
							href="delete.us?id=<%=user.getId()%>"><img
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