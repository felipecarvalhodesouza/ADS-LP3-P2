package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Crie um formulário (action = ""), padrão Servlet, para que o usuário informe um texto qualquer a ser tratado. 

Dentro da classe Servlet, mas fora do método "processRequest", crie os métodos "retornarMaiusculo" e "retornarMinusculo".

Recupere o texto informado pelo usuário e faça com que esse texto seja atribuído às funções de tornar maiúsculo e minúsculo. Trate-o nas funções e retorne-o em seguida; ao final, exiba esses valores tratados.*/

@WebServlet(name = "ServletFormulario", urlPatterns = { "/Formulario" })
public class ServletFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFormulario() {
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
            out.println("<title>Servlet para retornar texto tratado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet para retornar texto tratado</h1>");
            
            out.println("<form action='' method=''>");
            out.println("Texto: <input type='text' name='texto' " + "placeholder='Digite um texto'><br><br>");
            out.println("<input type='submit' value='Processar'>");
            out.println("</form><br><br>");
            
            if (request.getParameter("texto") != null && request.getParameter("texto").length() > 0){
               
            	// recupera os valores
                String textoOriginal = request.getParameter("texto");
                String textoMaiusculo = retornarMaiusculo(textoOriginal);
                String textoMinusculo = retornarMinusculo(textoOriginal);
                // exibe-os para o usuário
                out.println("<br><br>Texto original: " + textoOriginal);
                out.println("<br>Texto maiúsculo: " + textoMaiusculo);
                out.println("<br>Texto minúsculo: " + textoMinusculo);
                    
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
	
	private String retornarMaiusculo(String text) { 
		return text.toUpperCase();
	}
	
	private String retornarMinusculo(String text) { 
		return text.toLowerCase();
	}

}
