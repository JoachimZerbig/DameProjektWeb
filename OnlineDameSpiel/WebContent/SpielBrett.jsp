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
	width: 100px;
	height: 100px;
	min-width: 100px;
	min-height: 100px;
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
	char x = 'a';
	int y = 12;
	for (int i = 12; i > 0; i--) {
	out.print("</tr>");
		for (int j = 0; j < 12; j++) {
			if ((i+j) % 2 !=0) {
				
								
				if(y>=8){
				out.print("<td style=background: brown><a href=SpielZug?zug="+x+""+y+"><img src='images/Dame_Stein_braun_50w.png' alt='Bild'></a></td>");
				}
				else if(y<8 & y>5){
					out.print("<td style=background: brown><a href=SpielZug?zug="+x+""+y+">"+x+y+" </a></td>");	
				}
				else if(y<=5){
				out.print("<td style=background: brown><a href=SpielZug?zug="+x+""+y+"><img src='images/Dame_Stein_weiss_50.png' alt='Bild'></a></td>");
				}
			}
			else {
				out.print("<td style=background: beige></td>");
			}
			
		x++;
		}
	
	out.print("</tr>");
	y--;
	x='a';
	}
	%>	
	</table>
	<input type="button" value="refresh" name="refresh" />
	<form>
		<textarea readonly>
		Logging des anderen Spielers!!!
		<% %>
		</textarea>
	</form>
<%@ include file="Footer.jspf" %>
</body>
</html>
