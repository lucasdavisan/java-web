package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import negocio.Formato;

@WebServlet(name = "ServletTrataTexto", urlPatterns = {"/ServletTrataTexto"})
public class ServletTrataTexto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	
        	// Recupera o texto original.
            String textoOriginal = request.getParameter("texto");
            // Instancia o objeto da regra de negócio.
            Formato objFormato = new Formato();
            
            // Formata o texto recebido.
            String textoMaiusculo = "Maiúsculo: " + objFormato.retornarMaiusculo(textoOriginal);
            String textoMinusculo = "Minúsculo: " + objFormato.retornarMinusculo(textoOriginal);
            
            // De acordo com parte da regra de negócio, exibe o texto em saídas diferentes.
            if(textoOriginal.length() < 10) {
            	// Exibe no próprio Servlet
            	out.println("<h2>Servlet para Tratamento de Texto</h2>");
            	out.println("<h3>" + textoOriginal + "</h3>");
            	out.println("<h3>" + textoMaiusculo + "</h3>");
            	out.println("<h3>" + textoMinusculo + "</h3>");
            	
            } else if (textoOriginal.length() >= 10 && textoOriginal.length() <= 20) {
            	// Redireciona para a "index.jsp"
            	request.setAttribute("maiusculo", textoMaiusculo);
            	request.setAttribute("minusculo", textoMinusculo);
            	request.getRequestDispatcher("index.jsp").include(request, response); 
            	
            } else {
            	// Redireciona para a "textoFormatado.jsp"
            	request.setAttribute("maiusculo", textoMaiusculo);
            	request.setAttribute("minusculo", textoMinusculo);
            	request.getRequestDispatcher("textoFormatado.jsp").forward(request, response); 
            }
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
