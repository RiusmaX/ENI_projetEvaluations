<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="../../css/style.css" /> -->
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-2.0.3.min.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<title>Valider le test</title>
</head>
<body>
	<div class="container">
		<div class="col-md-5">
			<s:form theme="simple" action="validerTest">
				<fieldset>
					<legend>Valider le test</legend>
					<p>Etes-vous sur de valider le test ?</p>
					<div class="col-md-3">
						<a class="btn btn-warning" href="PasserTest.jsp">Non</a>
					</div>
					<div class="col-md-2">
						<s:submit cssClass="btn btn-primary" name="Valider" value="Oui"/>
					</div>
				</fieldset>
			</s:form>
		</div>
	</div>
</body>
</html>