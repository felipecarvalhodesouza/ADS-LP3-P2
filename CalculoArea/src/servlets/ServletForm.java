package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletForm", urlPatterns = {"/inicio"})
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletForm() {
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Formul�rio para c�lculo de �rea</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Formul�rio para c�lculo de �rea</h1>");
            
            out.println("<form action='ServletFiguras' method='get'>");
            out.println("Raio: <input type='text' name='raio'>&nbsp;");
            out.println("Base: <input type='text' name='base'>&nbsp;");
            out.println("Altura: <input type='text' name='altura'><br><br>");
            out.println("<input type='submit' name='btnCalcular' value='Calcular �rea do c�rculo'>&nbsp;");
            out.println("<input type='submit' name='btnCalcular' value='Calcular �rea do ret�ngulo'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

}
