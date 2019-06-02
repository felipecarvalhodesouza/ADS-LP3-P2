package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Calculo;

/* 
Crie um novo projeto no padrão Servlet. Crie um pacote para a regra de negócio (sugestão de nome: "negocio"), onde deverá existir uma classe chamada "Calculo", que irá realizar os cálculos das 4 operações aritméticas básicas. A classe Calculo deve implementar a interface ICalculo abaixo:

interface ICalculo{
    float somar();
    float subtrair();
    float multiplicar();
    float dividir();
}

Num outro pacote (chamado "servlets"), crie o Servlet ("ServletCalculadora") e, dentro deste, crie um formulário para receber 2 valores numéricos e instanciar objetos da classe "Calculo". 

Receba (via formulário) os valores informados pelo cliente e passe-os ao objeto da Calculo, realizando as 4 operações aritméticas (cada uma em um botão diferente) e devolvendo o resultado ao cliente (via HTML).
 */

@WebServlet(name ="ServletCalculadora", urlPatterns = {"/Calculadora"})
public class ServletCalculadora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCalculadora() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculadora</h1>");
            
            out.println("<form action='' method='get' name='formCalculadora'>");
            out.println("Valor 1: <input type='text' name='valor1'><br>");
            out.println("Valor 2: <input type='text' name='valor2'><br><br>");
            out.println("<input type='submit' name='btnCalcular' value='+'>&nbsp;");
            out.println("<input type='submit' name='btnCalcular' value='-'>&nbsp;");
            out.println("<input type='submit' name='btnCalcular' value='x'>&nbsp;");
            out.println("<input type='submit' name='btnCalcular' value='/'>");
            out.println("</form>");
            
            if (request.getParameter("valor1") != null &&
                request.getParameter("valor1").length() > 0 &&
                request.getParameter("valor2") != null &&
                request.getParameter("valor2").length() > 0){
                // recupera os valores informados e os converte para float
                float v1 = Float.parseFloat(request.getParameter("valor1"));
                float v2 = Float.parseFloat(request.getParameter("valor2"));
                // instancia objeto da regra de negócio
                Calculo objCalc = new Calculo(v1, v2);
                // recupera a operação arimética desejada
                String operacao = request.getParameter("btnCalcular");
                // declara variável para receber o resultado da operação
                float resultado = 0;
                // executa a operação selecionada
                switch (operacao){
                    case "+": resultado = objCalc.somar(); break;
                    case "-": resultado = objCalc.subtrair(); break;
                    case "x": resultado = objCalc.multiplicar(); break;
                    case "/": resultado = objCalc.dividir(); break;
                }
                
                // exibe o resultado
                out.println(String.format("<br><b>Resultado: %.2f <b><br>", resultado));
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
