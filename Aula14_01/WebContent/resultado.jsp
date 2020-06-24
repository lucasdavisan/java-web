<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<h1>JSP com Servlet!</h1>
		<h3>Resultado:</h3>
		
		<%= request.getAttribute("mensagem").toString() %>
	</body>
</html>