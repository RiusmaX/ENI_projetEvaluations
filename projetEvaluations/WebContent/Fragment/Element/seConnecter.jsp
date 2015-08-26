<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Connection</title>
</head>
<body>
	<h1>Connection</h1>
	<s:form action="valider">
      <s:textfield key="login" name="login"/>
      <s:password key="password" name="password"/>
      <s:submit key="valider" action="valider"/>
    </s:form>
</body>
</html>