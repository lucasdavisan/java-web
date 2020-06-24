<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP - Texto Formatado</title>
	</head>
	<body>
		<h1>JSP - Texto Formatado</h1>
		<%
			if(request.getAttribute("maiusculo") != null) {
		%>
				<h3><%= request.getParameter("texto") %></h3>
				<h3><%= request.getAttribute("maiusculo").toString() %></h3>
				<h3><%= request.getAttribute("minusculo").toString() %></h3>
		<%
			}
		%>
	</body>
</html>