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

td {
	display: inline-block;
	width: 50px;
	height: 50px;
	min-width: 50px;
	min-height: 50px;
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
			<td style="background: brown">2</td>
			<%
				} else {
			%>
			<td style="background: beige">2</td>
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