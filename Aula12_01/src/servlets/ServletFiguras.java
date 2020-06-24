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
@WebServlet(name = "ServletFiguras", urlPatterns = {"/calculo_area"})
public class ServletFiguras extends HttpServlet {

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
            
            // Valida se os dados foram preenchidos
            if(request.getParameter("raio") != null) {
            	// Declara objeto da classe abstrata
            	Figura objFigura = null;
            	if(request.getParameter("btnCalcular").equals("Calcular circulo")) {
            		float raio = Float.parseFloat(request.getParameter("raio"));
            		/* Instancia a classe correspondente à operação desejada, atribuindo,
            		via upcasting, ao objeto da superclasse (abstrata).*/
            		objFigura = new Circulo(raio);
            	} else {
            		float base = Float.parseFloat(request.getParameter("base"));
            		float altura = Float.parseFloat(request.getParameter("altura"));
            		/*Instancia a classe correspondente à operação desejada, atribuindo,
             		via upcasting, ao objeto da superclasse (abstrata).*/
            		objFigura = new Retangulo(base, altura);
            	}
            	// Executa regra de negócio
            	objFigura.calcularArea();
            	out.println(String.format("<b>Área calculada: %.2f cm².</b>", objFigura.getArea()));
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

