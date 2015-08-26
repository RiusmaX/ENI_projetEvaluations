<h1>Modifier une section</h1>
	
<s:form action="enregistrerSection">
     	<s:textfield label="Nom de la section" name="nomSection" placeholder="Nom"/>
    	<s:textfield label="Nombre de question minimum" name="nbQuestions" placeholder="Nombre de question"/>
   	<s:combobox label="Thème associé à la section" headerKey="-1" headerValue="--- Choix ---" list="#{'1':'theme 1','2':'theme2','3':'theme 3','4':'theme4'}" name="theme" />
	<s:submit action="Confirmer" name="Valider" value="Enregistrer"/>
</s:form>