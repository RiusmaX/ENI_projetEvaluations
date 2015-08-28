function ajoutChampsUneRep() {
	var a = document.getElementById("ajoutChampsUneRep");
	a.innerHTML += '<div id="ajoutChampsUneRep"><input type="text" name="reponseQuestion" placeholder="Réponse"/> <input type="radio" name="bonneRep" value="1"></br></div>';
	
}
function supprimerChampsUneRep() {
	var element = document.getElementById("ajoutChampsUneRep");
	// boucle tant qu'un enfant existe
	while (element.firstChild) {
	   // le supprime
	   	element.removeChild(element.firstChild);
	   
	}
}
function ajoutChampsPlusieursRep() {
	var a = document.getElementById("ajoutChampsPlusieursRep");
	a.innerHTML += '<input type="text" name="reponseQuestion" placeholder="Réponse"/> <input type="checkbox" name="bonneRep" value="1"></br>';
}
function supprimerPlusieursRep() {
	var element = document.getElementById("ajoutChampsPlusieursRep");
	// boucle tant qu'un enfant existe
	while (element.firstChild) {
	   // le supprime
	   	element.removeChild(element.firstChild);
	   
	}
}
