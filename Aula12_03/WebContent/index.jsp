<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Tabela JSP + HTML</h1>
	<table border="1">
		<tr>
			<td></td>
			<td>Coluna 1</td>
			<td>Coluna 2</td>
			<td>Coluna 3</td>
		</tr>
		<%
			for(int row = 1; row <= 10; row++) {
		%>
			<tr>
				<td>Linha: <%= row %></td>
				<%
					for(int col = 1; col <= 3; col++) {
				%>
					<td><%= row %>, <%= col %></td>
					<%
					}
					%>
			</tr>
			<%
			}
			%>
	</table>
</body>
</html>