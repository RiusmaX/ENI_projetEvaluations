<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<title>Sélectionner un test</title>
</head>
<body>
	<h2>Sélectionner un test</h2>
	
	<s:iterator value="test" var="test">
		<s:if test="isArchive=='true'">
			<a href="" class="btn btn-primary" disabled><s:property value="test.name"/></a>
			<a href="Resultat.jsp">Voir le résultat</a><br/>
		</s:if>
		<s:else>
		    <a href="PasserTest.jsp" class="btn btn-primary"><s:property value="test.name"/></a><br/>
		</s:else>
	</s:iterator>
	
<!-- 	<a href="" class="btn btn-primary" disabled>C# - Variables</a> -->
<!-- 	<a href="Resultat.jsp">Voir le résultat</a><br/> -->
<!-- 	<a href="PasserTest.jsp" class="btn btn-primary">C# - Initiation</a><br/> -->
<!-- 	<a href="PasserTest.jsp" class="btn btn-primary">C# - POO</a><br/> -->
	
	<a href="Accueil.jsp" class="btn btn-default">Retour à l'accueil</a><br/>
</body>
</html>