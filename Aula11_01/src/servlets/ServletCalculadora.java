package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Adicao;
import negocio.Subtracao;
import negocio.Multiplicacao;
import negocio.Divisao;
import negocio.ICalculo;

@WebServlet(name = "ServletForm", urlPatterns = {"/form"})
public class ServletCalculadora extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulário</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Calculadora Aritmética</h3>");
            	
            // Monta o formulario para receber dados do usuario
            out.println("<form action='' method='POST'>");
            out.println("v1: <input type='text' name='valor1' size='5' />");
            out.println("v2: <input type='text' name='valor2' size='5' /><br/><br/>");
            out.println("<input type='submit' name='btnCalcular' value='Somar' />");
            out.println("<input type='submit' name='btnCalcular' value='Subtrair' />");
            out.println("<input type='submit' name='btnCalcular' value='Multiplicar' />");
            out.println("<input type='submit' name='btnCalcular' value='Dividir' />");
            out.println("</form>");

            // Verifica se os valores foram devidamente preenchidos
            if(request.getParameter("valor1") != null && request.getParameter("valor2") != null) {
            	float v1 = Float.parseFloat(request.getParameter("valor1"));
            	float v2 = Float.parseFloat(request.getParameter("valor2"));
            	
            	// Recupera qual operacao foi selecionada
            	String operacao = request.getParameter("btnCalcular");
            	
            	// Declara um objeto da interface ICalculo
            	ICalculo objCalc = null;
            	if(operacao.equals("Somar")) {
            		objCalc = new Adicao(v1, v2);
            	} else if(operacao.equals("Subtrair")) {
            		objCalc = new Subtracao(v1, v2);
            	} else if(operacao.equals("Multiplicar")) {
            		objCalc = new Multiplicacao(v1, v2);
            	} else if(operacao.equals("Dividir")) {
            		objCalc = new Divisao(v1, v2);
            	}
            	
            	if(objCalc != null) {
            		float resultado = objCalc.calcular();
            		out.println(String.format("<br>Resultado: %.2f", resultado));
            	}
            }
            
	        out.println("</body>");
	        out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
