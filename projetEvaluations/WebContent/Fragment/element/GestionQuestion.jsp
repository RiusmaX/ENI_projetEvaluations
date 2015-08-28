<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="../../css/jquery-te-1.4.0.css" />
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript" src="../../js/jquery-te-1.4.0.min.js"></script>
<script type="text/javascript" src="../../js/gestionQuestion.js"></script>

<title>Gestion des questions</title>
</head>
<body>
<div class="container">
	<h2>Gestion des questions</h2>
	<fieldset>
	<legend>Ajouter une question</legend>
	<div class="label col-md-6">
		<s:form action="enregistrerQuestion">
	      	<s:textarea cssClass="textareaQuestion" label="Enoncé" name="enonceQuestion" placeholder="Enoncé"/>
	     	<s:select label="Type de réponse" headerKey="-1" headerValue="--- Choix ---" list="#{'1':'1 seule bonne réponse','2':'2 bonnes réponses ','3':'3 bonnes réponses','4':'4 bonnes réponses'}" name="natureTest"/>
			<s:submit cssClass="btn btn-warning" action="enregistrerQuestion" name="Valider" value="Enregistrer"/>
	    </s:form>
     </div>
     <hr width="0.5px" size="70px">
     <div class="col-md-6">
	    <div role="tabpanel">
		    <!-- Nav tabs -->
		    <ul class="nav nav-tabs" role="tablist">
		      <li role="presentation" class="active"><a href="#uneRep" aria-controls="uneRep" role="tab" data-toggle="tab">Une seule réponse</a></li>
		      <li role="presentation"><a href="#plusieursRep" aria-controls="plusieursRep" role="tab" data-toggle="tab">Plusieurs réponses</a></li>
		      <li role="presentation"><a href="#personnaliseRep" aria-controls="personnaliseRep" role="tab" data-toggle="tab">Personnaliser</a></li>
		    </ul>
		  
		    <!-- Tab panes -->
		    <div class="tab-content">
		    	<!-- Une réponse -->
		      <div role="tabpanel" class="tab-pane active" id="uneRep">
		      	<s:form theme="simple" action="enregistrerReponse">
		    		<p><strong>Cocher la réponse correcte</strong></p>
		    		<s:textfield name="reponseQuestion" placeholder="Réponse"/>
		    		<s:radio name="bonneRep" list="#{'1':''}" /></br>
		      		<s:textfield name="reponseQuestion" placeholder="Réponse"/>
			    	<s:radio name="bonneRep" list="#{'1':''}" /></br>
			    	<s:textfield name="reponseQuestion" placeholder="Réponse"/>
			    	<s:radio name="bonneRep" list="#{'1':''}" /></br>
			    	<s:textfield name="reponseQuestion" placeholder="Réponse"/>
			    	<s:radio name="bonneRep" list="#{'1':''}" /></br>
			    	<div id="ajoutChampsUneRep"></div>
			    	<input type='button' onclick='ajoutChampsUneRep();' class="btn btn-warning" value='+'/>
			    	<input type='button' onclick='supprimerChampsUneRep();' class="btn btn-danger" value='-'/></br>
			    	<s:submit cssClass="btn btn-primary" action="enregistrerReponse" name="Valider" value="Ajouter"/>
				</s:form>
		      </div>
		      
		      <!-- Plusieurs réponses -->
		      <div role="tabpanel" class="tab-pane" id="plusieursRep">
		      	<s:form theme="simple" action="enregistrerReponse">
			    	<p><strong>Cocher les réponses correctes (plusieurs réponses possibles)</strong></p>
			    	<s:textfield name="reponseQuestion" placeholder="Réponse"/>
			    	<s:checkbox name="bonneRep" fieldValue="true"/></br>
			      	<s:textfield name="reponseQuestion" placeholder="Réponse"/>
				    <s:checkbox name="bonneRep" fieldValue="true"/></br>
				    <s:textfield name="reponseQuestion" placeholder="Réponse"/>
				    <s:checkbox name="bonneRep" fieldValue="true"/></br>
				    <s:textfield name="reponseQuestion" placeholder="Réponse"/>
				   	<s:checkbox name="bonneRep" fieldValue="true"/></br>
				   	<div id="ajoutChampsPlusieursRep"></div>
				    <input type='button' onclick='ajoutChampsPlusieursRep();' class="btn btn-warning" value='+'/>
				    <input type='button' onclick='supprimerPlusieursRep();' class="btn btn-danger" value='-'/></br>
				    <s:submit cssClass="btn btn-primary" action="enregistrerReponse" name="Valider" value="Ajouter"/>
				</s:form>
		      </div>
		      
		      <!-- Personnaliser réponses -->
		      <div role="tabpanel" class="tab-pane" id="personnaliseRep">
		      	 <s:form theme="simple" action="enregistrerReponse">
		      	 	<p><strong>Entrez votre question</strong></p>
			    	<s:textarea cssClass="editor"></s:textarea></br>
					<s:submit cssClass="btn btn-primary" action="enregistrerReponse" name="Valider" value="Ajouter une réponse"/>		
			    </s:form>
			    <!-- <textarea class="editor" name="editor">Entrez votre question ici</textarea> -->  
		      </div>
		    </div>
	  	</div>
  	</div>
  	</fieldset>
</div> 
<script>
$(".editor").jqte(
		{button : "SEND"}
);
</script>
</body>
</html>