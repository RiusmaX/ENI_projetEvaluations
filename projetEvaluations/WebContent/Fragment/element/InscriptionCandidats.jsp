<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="../../css/jquery.datetimepicker.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="../../js/jquery.datetimepicker.js"></script>
<script src="../../js/inscriptionCandidat.js"></script>

<title>Inscrire les candidats</title>
</head>
<body>
	
	<h2>Gestion d'une session de test</h2>
	
	<s:form theme="simple" action="inscriptionCandidat">
		<div class="col-md-12">
			<div class="col-md-3">
				<strong>Type de test : </strong><br/>
				<s:select name="typeTest" list="#{'01':'ECF','02':'Tests de logique'}"></s:select><br/>
				<strong>Tests : </strong><br/>
				<s:select cssClass="cssSelect" multiple="true" list="#{'1':'JEE - Basic','2':'C#','3':'JEE - Avancé','4':'Android'}" name="test" /><br/>
			</div>
			<div class="col-md-2">
				<strong>Candidats : </strong><br/>
				<s:select cssClass="cssSelect" multiple="true" list="#{'Jean DUPONT':'Jean DUPONT','Laura LILAS':'Laura LILAS','René RENAULT':'René RENAULT','Kevin CARS':'Kevin CARS'}" name="candidat" id="candidat"/><br/>	
			</div>
			<div class="col-md-2">
				<input type="button" class="btn btn-primary" value="Ajouter --&gt;"
				 onclick="moveOptions(this.form.candidat, this.form.candidatInscrit);" /><br />
				<br/>
				<input type="button" class="btn btn-warning" value="&lt;-- Retirer"
				 onclick="moveOptions(this.form.candidatInscrit, this.form.candidat);" /><br/>
				<br/>
				<input type="button" class="btn btn-danger" onclick="selectAllOptions('sel2',this.form.candidatInscrit, this.form.candidat)" value="Réinitialiser"/>
				<br/>
			</div>
			<div class="col-md-2">
				<strong>Candidats inscrits : </strong><br/>
				<s:select cssClass="cssSelect" multiple="true" list="#{}" name="candidatInscrit" id="candidatInscrit" /><br/>
			</div>
			<div class="col-md-3">
				<strong>Paramètres de la session : </strong>
				<fieldset>
					<legend>Début</legend>
					<input id="datetimepickerDebut" type="text" placeholder="date"><br/>
				</fieldset>
				<fieldset>
					<legend>Fin</legend>
					<input id="datetimepickerFin" type="text" placeholder="date"><br/>
				</fieldset>
			</div>
		</div>
		<s:submit cssClass="btn btn-primary" name="enregistrerCandidat" value="Enregistrer"/><br/>
	</s:form>
	
	<script>
		jQuery('#datetimepickerDebut').datetimepicker();
		jQuery('#datetimepickerFin').datetimepicker();
	</script>
</body>
</html>