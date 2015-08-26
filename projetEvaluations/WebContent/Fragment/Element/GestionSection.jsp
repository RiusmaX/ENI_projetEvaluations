<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Gestion des Sections</title>
</head>
<body>
	<h1>Ajouter une section</h1>
	
	<s:form action="Confirmer">
      <s:textfield key="Nom" name="nom"/>
      
      <s:combobox label="Thème associé à la section" 
      	headerKey="-1" 
      	headerValue="--- Select ---" 
      	list="#{'1':'theme 1','2':'theme2','3':'theme 3','4':'theme4'}"  
      	name="theme" 
      />
      
      <s:submit key="saisie.valider" action="Confirmer" name="Valider"/>
    </s:form>
    
</body>
</html>