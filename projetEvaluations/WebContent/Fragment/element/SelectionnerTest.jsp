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
<title>Sélectionner un test</title>
</head>
<body>
	<div class="col-md-6 col-md-offset-3">
		<h2>Sélectionner un test</h2>
		<table class="table">
			<s:iterator value="test" var="test">
				<tr>
					<s:if test="isArchive=='true'">
						<td><a href="" class="btn btn-primary" disabled><s:property value="test.name"/></a></td>
						<td><a href="Resultat.jsp" class="lienVersResultat">Voir le résultat</a><br/></td>
						<br/>
					</s:if>
					<s:else>
					    <td colspan="2"><a href="PasserTest.jsp" class="btn btn-warning"><s:property value="test.name"/></a><br/></td>
					    <td>
					    <br/>
					</s:else>
				</tr>
			</s:iterator>
		</table>
		
<!-- 		<table class="table"> -->
<!-- 			<tr> -->
<!-- 				<td><a href="" class="btn btn-default" disabled>C# - Variables</a></td> -->
<!-- 				<td><a href="Resultat.jsp" class="lienVersResultat">Voir le résultat</a><br/><br/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"><a href="PasserTest.jsp" class="btn btn-primary">C# - Initiation</a><br/><br/></td> -->
<!-- 			</tr> -->
<!-- 				<td colspan="2"><a href="PasserTest.jsp" class="btn btn-primary">C# - POO</a><br/>	<br/></td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
		
	</div>
	<div class="col-md-6 col-md-offset-8">
		<a href="Accueil.jsp" class="btn btn-default">Retour à l'accueil</a><br/>
	</div>
</body>
</html>