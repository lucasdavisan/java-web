package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Massa;

@WebServlet(name = "ServletConversaoDeMassa", urlPatterns = {"/ServletConversaoDeMassa"})
public class ServletConversaoDeMassa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>JSP (com Servlet) para Conversão de Massa</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>JSP (com Servlet) para Conversão de Massa</h2>");
            
            //Verifica se o valor da massa foi enviado
            if (request.getParameter("massa") != null &&
            	request.getParameter("massa").length() > 0) {
                
            	// Recupera o valor informado pelo usuário
                float massaOriginal = Float.parseFloat(request.getParameter("massa"));
                float massaConvertida = 0;
                // Verifica a operação/conversão desejada
                if (request.getParameter("btnConverter").equals("kg para lb")) {
                	massaConvertida = new Massa().converterQuiloParaLibra(massaOriginal);
                	out.println(String.format("Resultado: %.2f lb.", massaConvertida));
                } else {
                	massaConvertida = new Massa().converterLibraParaQuilo(massaOriginal);
                	out.println(String.format("Resultado: %.2f kg.", massaConvertida));
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
