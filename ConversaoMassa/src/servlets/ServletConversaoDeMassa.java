package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Massa;

@WebServlet(name = "ServletConversaoDeMassa", urlPatterns = { "/ConversaoDeMassa" })
public class ServletConversaoDeMassa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConversaoDeMassa() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet para conversão de massas</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet para conversão de massas</h1>");

			if (request.getParameter("massa") != null && request.getParameter("massa").length() > 0) {

				// recupera a massa original a ser convertida
				float massaOriginal = Float.parseFloat(request.getParameter("massa"));
				float massaConvertida = 0;
				// recupera a conversão a ser realizada
				String conversaoSolicitada = request.getParameter("btnConverter");
				String msg = "";
				if (conversaoSolicitada.equals("kg para lb")) {
					massaConvertida = new Massa().converterQuiloParaLibra(massaOriginal);
					msg = String.format("<br>Massa original: %.2f kg; massa " + "convertida: %.2f lbs.", massaOriginal,
							massaConvertida);
				} else {
					massaConvertida = new Massa().converterLibraParaQuilo(massaOriginal);
					msg = String.format("<br>Massa original: %.2f lbs; massa " + "convertida: %.2f kg.", massaOriginal,
							massaConvertida);
				}
				out.println(msg);

			}

			out.println("</body>");
			out.println("</html>");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
