<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="negocio.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora JSP</title>
</head>
<body>
	<h2>Calculadora JSP</h2>
	
	<form>
		Valor 1: <input type="text" name="valor1"><br>
		Valor 2: <input type="text" name="valor2"><br><br>
		<input type="submit" name="btnCalcular" value="+">
		<input type="submit" name="btnCalcular" value="-">
		<input type="submit" name="btnCalcular" value="x">
		<input type="submit" name="btnCalcular" value="/">
	</form>
	
	<%
		if (request.getParameter("valor1") != null && 
			request.getParameter("valor1").length() > 0 && 
			request.getParameter("valor2").length() > 0) {
			
			float v1 = Float.parseFloat(request.getParameter("valor1"));
			float v2 = Float.parseFloat(request.getParameter("valor2"));
			
			if(request.getParameter("btnCalcular").equals("+")){
				out.println(String.format("<h3>Resultado: %.2f </h3>", new Adicao(v1, v2).calcular()));
				
			} else if(request.getParameter("btnCalcular").equals("-")) {
				Subtracao objSub = new Subtracao(v1, v2);
				float resultado = objSub.calcular();
				out.println(String.format("<h3>Resultado: %.2f </h3>", resultado));
				
			} else if(request.getParameter("btnCalcular").equals("x")) {
	%>
				<h3>Resultado: <%= String.format("%.2f", new Multiplicacao(v1, v2).calcular()) %></h3>
	<%	
			} else if (request.getParameter("btnCalcular").equals("/")) {
				float resultado = new Divisao(v1, v2).calcular();
				out.println(String.format("<h3>Resultado: %.2f </h3>", resultado));
			}
		}
	%>
</body>
</html>