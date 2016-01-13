<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Formulareingabe Spieler 2</title>
</head>
<body>
<%@ include file="Header.jspf" %>
<h1>Spieler 2</h1>
<form id="formular" action="AnmeldungPl2" method="get">
	<label for="spname">Spielername</label><input type="text" name="spname" id="spname"/><br/>
	<label for="schwarz">schwarz</label><input type="radio" name="farbe" id="schwarz" value="schwarz"/><br/>
	<label for="ki">KI</label><input type="radio" name="typ" id="ki" value="ki"/><br/>
	<label for="mensch">Mensch</label><input type="radio" name="typ" id="mensch" value="mensch"/><br/>
	<input type="submit" value="abschicken" name="abschicken"/>
	<input type="reset" value="zurücksetzen" name="zurueck"/>
</form>
<%@ include file="Footer.jspf" %>
</body>
</html>
