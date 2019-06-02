package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletForm", urlPatterns = { "/Form" })
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Form() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet para conversão de massas</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Formulário para conversão de massas</h1>");

			out.println("<form action='ConversaoDeMassa'>");
			out.println("Massa original: <input type='text' name='massa'><br><br>");
			out.println("<input type='submit' name='btnConverter' value='kg para lb'>&nbsp;");
			out.println("<input type='submit' name='btnConverter' value='lb para kg'>");
			out.println("</form>");

			out.println("</body>");
			out.println("</html>");
		}
	}

}
