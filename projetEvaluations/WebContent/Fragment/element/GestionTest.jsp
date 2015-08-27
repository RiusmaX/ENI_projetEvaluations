<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/globalize/1.0.0/globalize.js"></script>
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 

<title>Gestion des tests</title>
</head>
<body>
	<h2>Gestion des tests</h2>
	<s:form action="enregistrerTest">
      	<s:textfield label="Nom du test" name="nomTest" placeholder="Nom"/>
     	<s:select label="Nature du test" headerKey="-1" headerValue="--- Choix ---" list="#{'1':'ECF','2':'Test de logique ','3':'Tests de positionnement','4':'Test d’apprentissage '}" name="natureTest"/>
     	
		<sj:head jqueryui="true"/>
		<sj:spinner label="Temps maximal (en minutes)" name="tempsMax" id="tempsMax" min="0" max="240" step="1" value="180"/>
		<sj:spinner label="Seuil 'En cours d\'acquisition' en %" name="seuilECA" id="seuilECA" min="55" max="70" step="1" value="55"/>
		<sj:spinner label="Seuil 'Aquis' en %" name="seuilA" id="seuilA" min="70" max="100" step="1" value="70"/>
		
    	<s:select label="Thème associé à la section" multiple="true" list="#{'1':'section 1','2':'section 2','3':'section 3','4':'section 4'}" name="theme" />
		<s:submit action="ajouterSection" name="AjouterSection" value="Ajouter une section"/>
		<s:submit action="supprimerTest" name="Supprimer" value="Supprimer"/>
		<s:submit action="enregistrerTest" name="Valider" value="Enregistrer"/>
    </s:form>
    
</body>
</html>