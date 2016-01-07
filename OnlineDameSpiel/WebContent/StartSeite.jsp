<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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