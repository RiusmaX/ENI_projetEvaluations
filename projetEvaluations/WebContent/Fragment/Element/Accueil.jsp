<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="template.jsp" %>
<title>Accueil</title>
</head>
<body>
	<h1>Accueil</h1>
	<table align="center">
		<tr align="center">
			<td><a href="passerTest.jsp" class="btnAccueil" style="width:200px; height:50px;">Passer un test<a/></td>
			<td><a href="resultat.jsp" class="btnAccueil" style="width:200px; height:50px;">Résultats<a/></td>
			<td><a href="suivisCandidats.jsp" class="btnAccueil" style="width:200px; height:50px;">Suivis des candidatst<a/></td>
		</tr>
		</br>
		<tr align="center">
			<td><a href="gestionTests.jsp" class="btnAccueil" style="width:200px; height:50px;">Gestion des tests<a/></td>
			<td><a href="gestionInscriptions.jsp" class="btnAccueil" style="width:200px; height:50px;">Gestion des inscriptions<a/></td>
			<td><a href="seDeconnecter.jsp" class="btnAccueil" style="width:200px; height:50px;">Se déconnectert<a/></td>
		</tr>
	</table>
</body>
</html>