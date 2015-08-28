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
<title>Gestion des themes</title>
</head>
<body>
	<h2>Gestion des thèmes</h2>
	<div class="label">
		<s:form action="enregistrerTheme">
			<s:textfield label="Nom du thème" name="nomTheme" placeholder="Nom"/><br/>
			<s:checkbox label="Archiver ?" name="isArchive" fieldValue="true"/><br/>
			<s:submit cssClass="btn btn-primary" action="enregistrerTheme" name="Valider" value="Enregistrer"/>
		</s:form>
	</div>
</body>
</html>