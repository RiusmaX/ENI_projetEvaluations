<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link media="all" rel="stylesheet" href="../../css/style.css" type = "text/css"/>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">

<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="../../js/jquery.progressTimer.js"></script>  
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<!-- <script src="../../js/decompteProgressBar.js"></script>--> 

<title>Synthèse du test</title>
</head>
<body>
	<h4>Candidat : prenom nom </h4>
	<h1>Synthèse</h1></br>
	
	<table border="1"><tr><td><div id="compte_a_rebours"></div></td></tr></table>
  	<div id="progressTimer"></div></br>
  	
	<fieldset>
    	<legend>Légende </legend>
   		<font color="green">Répondu</font> <br>
   		<font color="red">Non répondu</font>
  	</fieldset></br>
  	
  	<fieldset>
    	<legend>Synthèse des questions </legend>
    	<!-- A automatiser -->
   		<font color="green">1</font> </br>
   		<font color="red">2</font> </br>
   		etc ...
  	</fieldset></br>
  	
  	<fieldset>
    	<legend>Questions marquées </legend>
    	<!-- A automatiser pour chaque questions marquées-->
   		<font color="orange"><a href="#" class="qMarquees">2 - #énoncé </a></font><br>
   	</fieldset></br>
   	
   	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">J'ai fini le test</button>
  	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Valider le test</h4>
			    </div>
      			<div class="modal-body">
			        <p>Etes-vous sur de valider le test ?</p>
			    </div>
      			<div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">Non</button>
					<!-- si "oui" clore le test -->
        			<a class="btn btn-primary" href="Resultat.jsp">Oui</a>
      			</div>
    		</div>
  		</div>
	</div>
  	
  	<script>
	function compte_a_rebours(total_secondes)
	{
		var compte_a_rebours = document.getElementById("compte_a_rebours");
		var prefixe = "Fin de l'épreuve dans ";
		
		/*if (total_secondes < 0)
		{
			prefixe = "Epreuve terminé"; // il y a "; // On modifie le préfixe si la différence est négatif
			total_secondes = Math.abs(total_secondes); // On ne garde que la valeur absolue
		}*/
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
		var date_evenement = new Date("Aug 26 12:30:00 2015");
		var total_secondes = (date_evenement - date_actuelle) / 1000;
		return (total_secondes);
	}
	compte_a_rebours(date());
	progressBar(date());
	</script>
</body>
</html>