<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP Page</title>
	</head>
<body>
	<h2>Hello World do JSP!</h2>
	<%
		out.println("Capturando data atual: ");
		// java.util.Date data = new java.util.Date(); => modo simplificado abaixo graças ao uso de diretiva
		Date data = new Date();
	%>
	<br>Agora são (via scriptlet):
	<%
		out.println(String.valueOf(data));
	%>
	<br>Agora são (via expressão scriptlet):
	<%= data %>
</body>
</html>