package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            out.println("<title>Servlet Formulário</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Conversor de Strings</h3>");
            	
            // Monta o formulario para receber dados do usuario
            out.println("<form action='' method='get'>");
            out.println("Digite um texto: <input type='text' name='txtInserido' size='20' placeholder='Informe uma string...' /><br/><br/>");
            out.println("<input type='submit' name='btnEnviar' value='Enviar dados' />");
            out.println("</form><br/><br/>");
            
            // Valida se os campos foram preenchidos
            if(request.getParameter("txtInserido") != null) {
    	        // Recupera os dados do usuario e exibe-os na propria pagina
    	        String txtInserido = request.getParameter("txtInserido");
    	        
    	        // Exibe os resultados na propria pagina
    	        out.println("Texto em MAIUSCULO: " + retornarMaiusculo(txtInserido) + "<br/><br/>");
    	        out.println("Texto em minusculo: " + retornarMinusculo(txtInserido));
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
    
    protected String retornarMaiusculo(String t) {
    	return t.toUpperCase();
    }
    
    protected String retornarMinusculo(String t) {
    	return t.toLowerCase();
    }
}
