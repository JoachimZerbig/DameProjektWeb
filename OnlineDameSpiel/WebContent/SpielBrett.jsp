<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}

td, a{
	display: inline-block;
	width: 50px;
	height: 50px;
	min-width: 50px;
	min-height: 50px;
}
a:hover{
	background: green;
}
</style>
</head>
<body>
	<table>
		<%
			for (int i = 11; i >= 0; i--) {
		%>
		<tr>
			<%
				for (int j = 0; j <= 11; j++) {
						if (i % 2 == j % 2) {
			%>
			
				<td style="background: brown"><a href="SpielZug"></a></td>
		
			<%
				} else {
			%>
			
				<td style="background: beige"><a href="SpielZug"></a></td>
			<%
				}
					}
			%>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>