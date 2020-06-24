<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP (com Servlet) para Conversão de Massa</title>
	</head>
	<body>
		<h2>JSP (com Servlet) para Conversão de Massa</h2>
		<form action="ServletConversaoDeMassa">
			Massa original: <input type="text" name="massa"><br><br>
			<input type="submit" name="btnConverter" value="kg para lb">
			<input type="submit" name="btnConverter" value="lb para kg">
		</form>
	</body>
</html>