package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.*;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet(name = "ServletForm", urlPatterns = {"/form"})
public class ServletForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora de Áreas</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action='/Aula12_01/calculo_area' method='GET'>");
            out.println("<h2>Cálculo Área do Círculo</h2>");
            out.println("Digite o raio: <input type='text' name='raio' size='5' /><br><br>");
            out.println("<input type='submit' name='btnCalcular' value='Calcular circulo' /><br><br>");
            out.println("<h2>Cálculo Área do Retângulo</h2>");
            out.println("Digite a base: <input type='text' name='base' size='5' /><br><br>");
            out.println("Digite a altura: <input type='text' name='altura' size='5' /><br><br>");
            out.println("<input type='submit' name='btnCalcular' value='Calcular retangulo' />");
            out.println("</form>");
            
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

