package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Massa;

@WebServlet(name = "ServletConversaoDeMassa", urlPatterns = {"/conversao"})
public class ServletConversaoDeMassa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Conversor de Pesos</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(request.getParameter("valor") != null &&
               request.getParameter("valor").length() > 0) {
            	float valor = Float.parseFloat(request.getParameter("valor"));
            	String operacao = request.getParameter("btnConverter");
            	
            	Massa objMassa = new Massa();
            	float resultadoConversao = 0;
            	
            	if(operacao.equals("kg-lb")) {	
            		resultadoConversao = objMassa.converterQuiloParaLibra(valor);
            		
            	} else if (operacao.equals("lb-kg")) {
            		resultadoConversao = objMassa.converterLibraParaQuilo(valor);
            	}
            	out.println(String.format("Massa convertida: %.2f", resultadoConversao));
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
