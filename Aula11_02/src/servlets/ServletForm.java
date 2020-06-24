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
            out.println("<title>Conversor de Pesos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Conversor de Pesos</h3>");
          
            out.println("<form action='/Aula11_02/conversao' method='POST'>");
            out.println("Digite um valor: <input type='text' name='valor' size='5' />");
            out.println("<input type='submit' name='btnConverter' value='kg-lb' />");
            out.println("<input type='submit' name='btnConverter' value='lb-kg' />");
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
