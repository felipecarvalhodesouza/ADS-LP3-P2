package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCadastroUsuario", urlPatterns = { "/CadastroUsuario" })
public class ServletCadastraUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadastraUsuario() {
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
            out.println("<title>Servlet para Cadastro de Usu�rio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet para Cadastro de Usu�rio</h1>");
            
            out.println("<form action='' method=''>");
            out.println("Nome: <input type='text' name='txtNome' " + "placeholder='Informe seu nome'><br>");
            out.println("E-mail: <input type='text' name='txtEmail' " + "placeholder='Informe seu e-mail'><br><br>");
            out.println("<input type='submit' value='Cadastrar usu�rio'>");
            out.println("</form><br><br>");
            
            if (request.getParameter("txtNome") != null && request.getParameter("txtNome").length() > 0 &&
                request.getParameter("txtEmail") != null && request.getParameter("txtEmail").length() > 0){

                    String nome = request.getParameter("txtNome");
                    String email = request.getParameter("txtEmail");

                    out.println(String.format("Ol�, %s, seja bem-vindo! " + "Seu login � %s", nome, email));
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
