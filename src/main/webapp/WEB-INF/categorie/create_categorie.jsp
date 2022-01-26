
<%@page import="beans.Categorie"%>
<%@page import="beans.Article"%>
<%@page import="beans.Utilisateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catégories</title>
</head>
<body>
	<h1>Ajouter une catégorie</h1>
	<a href="/ECommerceFliter/articles">Voir les articles</a>
	<br>
	<%@ include file="/WEB-INF/generic/message.jsp"%>
		<%
		List<Categorie> categorieExistantes = (List<Categorie>) request.getAttribute("categories");
		if (null == categorieExistantes  || categorieExistantes.isEmpty()) {
			out.println("<p> Vous devez d'abord créer un catégorie avant d'ajouter un article</p>");
		}
		%>
	<form action="" method="post">
		<label for="titre">Titre : </label> <br> <input type="text"
			id="titre" name="titre"> <br> <br> <input
			type="submit" value="Ajouter la categorie">
	</form>
	<br>
	<br>
	<h2>Voici la liste de vos categories :</h2>
	<ul>
		<%
		List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
		if (null != categories) {

			for (Categorie categorie : categories) {
				out.println("<li>");
				out.println("<p> Titre : " + categorie.getTitre() + "</p>");
				out.println("</li>");
			}
		}
		%>
	</ul>
</body>
</html>