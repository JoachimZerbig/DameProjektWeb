<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jspf" %>
<form id="formular" action="Anmeldung" method="get">
	<label for="spname">Spielername</label><input type="text" name="spname" id="spname"/><br/>
	<label for="weiß">weiß</label><input type="radio" name="farbe" id="weiß" checked="checked"/><br/>
	<label for="schwarz">schwarz</label><input type="radio" name="farbe" id="schwarz"/><br/>
	<label for="ki">KI</label><input type="radio" name="typ" id="ki"/><br/>
	<label for="mensch">Mensch</label><input type="radio" name="typ" id="mensch"/><br/>
	<input type="submit" value="abschicken" name="abschicken"/>
	<input type="reset" value="zurücksetzen" name="zurueck"/>
</form>
<%@ include file="Footer.jspf" %>
</body>
</html>