package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
            out.println("<h1>Servlet Formulário</h1>");
            out.println("<h3>Formulário HTML</h3>");
            	
            // Monta o formulario para receber dados do usuario
            out.println("<form action='' method='get'>");
            out.println("Nome: <input type='text' name='txtNome' size='20' placeholder='Informe seu nome...' /><br/><br/>");
            out.println("E-mail: <input type='email' name='txtEmail' size='50' placeholder='Informe seu email...' /><br/><br/>");
            out.println("<input type='submit' name='btnEnviar' value='Enviar dados' />");
            out.println("</form><br/><br/>");
            
            // Valida se os campos foram preenchidos
            if(request.getParameter("txtNome") != null && request.getParameter("txtEmail") != null) {
    	        // Recupera os dados do usuario e exibe-os na propria pagina
    	        String nome = request.getParameter("txtNome");
    	        String email = request.getParameter("txtEmail");
    	        
    	        // Exibe os resultados na propria pagina
    	        out.println("Olá, " + nome + ", seja bem-vindo!");
    	        out.println("Seu login é " + email + ".");
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
