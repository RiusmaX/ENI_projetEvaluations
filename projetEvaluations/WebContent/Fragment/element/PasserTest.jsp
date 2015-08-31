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
<script src="../../js/jquery.progressTimer.js"></script>  

<title>Passer le test</title>
</head>
<body>
	<h2>Test #0 - C# POO</h2>
	<table border="1"><tr><td><div id="compte_a_rebours"></div></td></tr></table>
  	<div id="progressTimer"></div></br>
  	
	<div role="tabpanel">
	    <!-- Nav tabs -->
	    <ul class="nav nav-tabs" role="tablist">
	    	<s:iterator value="themes" var="theme">
		    	<li role="presentation" class="active">
		    		<a href="#name" aria-controls="name" role="tab" data-toggle="tab">
		    			<s:property value="theme.name"/>
		    		</a>
		    	</li>
			</s:iterator>
	    </ul>
	  
	    <!-- Tab panes -->
	    <div class="tab-content">
			<s:iterator value="themes">
		    	<div role="tabpanel" class="tab-pane active" id="name">
		      		<s:form theme="simple" action="enregistrerTest">
						Marquer<br/>
						<s:iterator value="questions" var="question"> 
							<div class="label col-md-1">
				      			<s:checkbox name="isMarque" fieldValue="true"/><br/>
				      		</div>
				      		<fieldset>
				      			<legend>
									<s:property value="question.name"/>
	<!-- 								Question 1 : Quel est le ... ? -->
				      			</legend>
								<s:if test="type =='uneRep'}">
									(Une réponse attendue)<br/>
								</s:if>
								<s:if test="type =='plusieursRep'}">
									(Plusieurs réponses possibles)<br/>
								</s:if>
	<!-- 			      			(Une réponse attendue)<br/> -->
				      			<s:iterator value="reponses" var="reponse">		
				      				<s:radio name="reponseTest" list="#{'1':''}" />
				      				<s:property value="reponse.name"/></br>
	<!-- 			      				Elle n'a pas de type</br> -->
								</s:iterator>		
				      		</fieldset>
						</s:iterator>
			    		<br/>
			    		<s:submit cssClass="btn btn-primary" name="Valider" value="Afficher la synthèse"/>
					</s:form>
				</div>
			</s:iterator>
		</div>
	
	
<script>
	function compte_a_rebours(total_secondes)
	{
		var compte_a_rebours = document.getElementById("compte_a_rebours");
		var prefixe = "Fin de l'épreuve dans ";
		
		if (total_secondes < 0)
		{
			prefixe = "Epreuve terminé"; // il y a "; // On modifie le préfixe si la différence est négatif
			total_secondes = Math.abs(total_secondes); // On ne garde que la valeur absolue
		}
		if (total_secondes > 0)
		{
			var jours = Math.floor(total_secondes / (60 * 60 * 24));
			var heures = Math.floor((total_secondes - (jours * 60 * 60 * 24)) / (60 * 60));
			minutes = Math.floor((total_secondes - ((jours * 60 * 60 * 24 + heures * 60 * 60))) / 60);
			secondes = Math.floor(total_secondes - ((jours * 60 * 60 * 24 + heures * 60 * 60 + minutes * 60)));
	
			if (jours == 0)
			{
				jours = '';
			}
			if (heures == 0)
			{
				heures = '00';
			}
			if (heures < 10 && heures != 0)
			{
				heures = '0'+heures;
			}
			if (minutes == 0)
			{
				minutes = '00';
			}
			if (minutes < 10 && minutes != 0)
			{
				minutes = '0'+minutes;
			}
			if (secondes == 0)
			{
				secondes = '00';
			}
			if (secondes < 10 && secondes != 0)
			{
				secondes = '0'+secondes;
			}
			compte_a_rebours.innerHTML = prefixe + heures + ':' + minutes + ':' + secondes;
		}
		else
		{
			compte_a_rebours.innerHTML = 'Temps écoulé.';
		}
		var actualisation = setTimeout("compte_a_rebours(date());", 1000);	
	}
	
	function progressBar(total_secondes)
	{
		$("#progressTimer").progressTimer({
		    timeLimit: total_secondes,
		    warningThreshold: 60,
		    baseStyle: 'progress-bar-warning',
		    warningStyle: 'progress-bar-danger',
		    completeStyle: 'progress-bar-info',
		    onFinish: function() {
		        console.log("Temps écoulé");
		    }
		});
	}
	
	function date()
	{
		var date_actuelle = new Date();
								//date en anglais
		var date_evenement = new Date("Aug 31 12:30:00 2015");
		var total_secondes = (date_evenement - date_actuelle) / 1000;
		return (total_secondes);
	}
	compte_a_rebours(date());
	progressBar(date());
</script>
	
</body>
</html>