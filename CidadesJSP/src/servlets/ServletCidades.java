package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCidades", urlPatterns = {"/ServletCidades"})
public class ServletCidades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCidades() {
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

            String cidade = request.getParameter("txtCidade");
            switch(cidade){
                case "santos":
                    response.sendRedirect("http://www.santos.sp.gov.br");
                    break;
                case "são vicente":
                    response.sendRedirect("http://www.saovicente.sp.gov.br");
                    break;
                case "praia grande":
                    response.sendRedirect("http://www.praiagrande.sp.gov.br");
                    break;
                case "cubatão":
                    response.sendRedirect("http://www.cubatão.sp.gov.br");
                    break;
                case "guarujá":
                    response.sendRedirect("http://www.guaruja.sp.gov.br");
                    break;
                default:
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet ServletCidades</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Cidade Inválida</h1>");
                    out.println("</body>");
                    out.println("</html>");
            }
            
        }
    }
}
