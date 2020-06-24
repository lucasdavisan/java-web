package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "MeuServlet", urlPatterns = {"/MeuServlet"})
public class MeuServlet extends HttpServlet {

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
            
            out.println("<h2>Servlet MeuServlet</h2>");
            
            // Recupera o texto informado na "index".
            String texto = request.getParameter("texto");
            // Monta mensagem a ser encaminhada.
            String msg = "O texto recebido foi: " + texto;
            // Cria um novo elemento/atributo no request => usado para passar info entre arquivos
            request.setAttribute("mensagem", msg);
            
            // Configura elemento para encaminhar a continuidade da requisição.
            RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
            // Faz o enchaminhamento para o elemento configurado acima.
            rd.forward(request, response);
            
            /* Esse bloco retorna as informações para a página inicial "index.jsp"
            // Configura elemento para encaminhar a continuidade da requisição.
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            // Faz o enchaminhamento para o elemento configurado acima.
            rd.include(request, response);
            */
 
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
