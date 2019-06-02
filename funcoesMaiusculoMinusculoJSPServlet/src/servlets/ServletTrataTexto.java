package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Formato;

@WebServlet(name = "ServletTrataTexto", urlPatterns = {"/TrataTexto"})
public class ServletTrataTexto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTrataTexto() {
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
            out.println("<title>Servlet para tratamento de texto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet para tratamento de texto</h1>");
            
            // recupera o texto recebido
            String texto = request.getParameter("texto");
            // declara a variável do tipo dispatcher
            RequestDispatcher rd = null;
            // formata o texto utilizando as regras de negócios
            String textoMaiusculo = new Formato().retornarMaiusculo(texto);
            String textoMinusculo = new Formato().retornarMinusculo(texto);
            if (texto.length() < 10){
                out.println("<h3><p>Texto original: " + texto + "</p>");
                out.println("<p>Texto maiúsculo:  " + textoMaiusculo + "</p>");
                out.println("<p>Texto minúsculo:  " + textoMinusculo + "</h3>");
            }
            else if (texto.length() <= 20){
                request.setAttribute("textoMaiusculo", textoMaiusculo);
                request.setAttribute("textoMinusculo", textoMinusculo);
                rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
            else{
                request.setAttribute("textoMaiusculo", textoMaiusculo);
                request.setAttribute("textoMinusculo", textoMinusculo);
                rd = request.getRequestDispatcher("textoFormatado.jsp");
                rd.forward(request, response);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
