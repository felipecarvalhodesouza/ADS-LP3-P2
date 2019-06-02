package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Circulo;
import negocio.IFigura;
import negocio.Retangulo;

@WebServlet(name = "ServletFiguras", urlPatterns = {"/ServletFiguras"})
public class ServletFiguras extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletFiguras() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet para cálculo de área</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet para cálculo de área</h1>");
            
            IFigura objFigura = null;
            if (request.getParameter("btnCalcular").contains("ngulo")){
                float base = Float.parseFloat(request.getParameter("base"));
                float altura = Float.parseFloat(request.getParameter("altura"));
                objFigura = new Retangulo(base, altura);
            }
            else{
                float raio = Float.parseFloat(request.getParameter("raio"));
                objFigura = new Circulo(raio);
            }
            out.println(String.format("Área calculada: %.2f cm².", objFigura.calcularArea()));
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
