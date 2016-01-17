<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Spielbrett</title>
<style>
table {
	border-collapse: collapse;
	margin: 0 auto;
}

td, a {
	display: inline-block;
	width: 50px;
	height: 50px;
	min-width: 50px;
	min-height: 50px;
}

a:hover {
	background: green;
}
textarea{
	display: block;
	width: 625px;
	height: 150px;
	margin: 0 auto;
	text-align: center;
}
</style>
</head>
<body>
<%@ include file="Header.jspf" %>
	<table>
		<%
			for (int i = 11; i >= 0; i--) {
		%>
		<tr>
			<%
				for (int j = 0; j <= 11; j++) {
						String ij = "" + i + j;
						if (i % 2 == j % 2) {
			%>

			<td style="background: brown">
				<a href="SpielZug?zug=<%out.print(ij);%>"><%out.print(ij);%></a></td>

			<%
				} else {
			%>

			<td style="background: beige">
				<a href="SpielZug?zug=<%out.print(ij);%>"><%out.print(ij);%></a></td>
			<%
				}
					}
			%>
		</tr>
		<%
			}
		%>
	</table>
	<form>
		<textarea readonly>
		Logging des anderen Spielers!!!
		<% %>
		</textarea>
	</form>
<%@ include file="Footer.jspf" %>
</body>
</html>