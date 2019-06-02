package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Massa;

@WebServlet(name = "ServletConversaoDeMassa", urlPatterns = {"/ConversaoDeMassa"})
public class ServletConversaoDeMassa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConversaoDeMassa() {
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
			out.println("<title>Servlet para conversão de massa</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet para conversão de massa</h1>");

			// instancia objeto da regra de negócio
			Massa objMassa = new Massa();
			float massaConvertida = 0;
			String msgResultado = "";
			// recupera o valor original
			float massaOriginal = Float.parseFloat(request.getParameter("massaOriginal"));
			// faz a conversão de acordo com o botão clicado
			if (request.getParameter("btnConverter").equals("de lb para kg")) {
				massaConvertida = objMassa.converterLibraParaQuilo(massaOriginal);
				msgResultado = String.format("Libras: %.2f; quilos: %.2f", massaOriginal, massaConvertida);
			} else {
				massaConvertida = objMassa.converterQuiloParaLibra(massaOriginal);
				msgResultado = String.format("Quilos: %.2f; libras: %.2f", massaOriginal, massaConvertida);
			}
			out.println(msgResultado);

			out.println("</body>");
			out.println("</html>");
		}
	}

}
