<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Herzlich Willkommen</title>
</head>

<body>
<%@ include file="Header.jspf"%>
<form id="formularStart" name="formularStart" method="get" action="Anmeldung">
<input type="submit" value="neues Spiel" name="neuesSpiel">
<input type="submit" value="beitreten" name="spielBeitreten">
</form>
<%@ include file="Footer.jspf" %>
</body>

</html>