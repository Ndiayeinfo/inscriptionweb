<%@page import="org.omg.CORBA.OMGVMCID"%>
<%@page import="web.model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="metier.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="lister.us">Daaray Kocc</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="lister.us">Accueil</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="lister.us"
					id="navbarDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> Utilisateur </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="ajouter.us">Ajouter</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="lister.us">Lister</a></li>
					</ul></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="lister.is"
					id="navbarDropdown" role="button" data-bs-toggle="dropdown"
					aria-expanded="false"> Inscription </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="ajouter.is">Ajouter</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="lister.is">Lister</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link"
					aria-current="page" href="<%=request.getContextPath()%>/logout">Se déconnecter</a></li>
			</ul>
			<form class="d-flex" action="chercher.us">
				<input class="form-control me-2" type="search"
					placeholder="Chercher" aria-label="Chercher" name="motCle"
					autocomplete="off"
					value="<%if (request.getParameter("motCle") != null) {
	out.print(request.getParameter("motCle"));
}%>">
				<button class="btn btn-outline-success" type="submit">Chercher</button>
			</form>
		</div>
	</div>
</nav>