$( document ).ready(function() {
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
			if (minutes == 0)
			{
				minutes = '00';
			}
			if (secondes == 0)
			{
				secondes = '00';
			}
			compte_a_rebours.innerHTML = prefixe + heures + ':' + minutes + ':' + secondes;
		}
		else
		{
			compte_a_rebours.innerHTML = 'Temps écoulé.';
		}
		var actualisation = setTimeout("compte_a_rebours", 5000);	
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
		var date_evenement = new Date("Aug 26 10:30:00 2015");
		var total_secondes = (date_evenement - date_actuelle) / 1000;
		return (total_secondes);
	}
	compte_a_rebours(date());
	progressBar(date());
	//compte_a_rebours();
});
