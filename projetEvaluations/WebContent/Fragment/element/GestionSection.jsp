<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Gestion des Sections</title>
</head>
<body>
	<h2>Ajouter une section</h2>
	
	<s:form action="enregistrerSection">
      	<s:textfield label="Nom de la section" name="nomSection" placeholder="Nom"/>
     	<s:textfield label="Nombre de question minimum" name="nbQuestions" placeholder="Nombre de question"/>
    	<s:select label="Thème associé à la section" headerKey="-1" headerValue="--- Choix ---" list="#{'1':'theme 1','2':'theme2','3':'theme 3','4':'theme4'}" name="theme" />
		<s:submit action="Confirmer" name="Valider" value="Enregistrer"/>
    </s:form>
    
    
</body>
</html>