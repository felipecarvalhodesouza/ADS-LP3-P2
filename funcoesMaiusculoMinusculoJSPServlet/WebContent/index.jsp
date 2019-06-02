<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tratamento de textos</title>
    </head>
    <body>
        <h1>Tratamento de textos</h1>
        <form action="TrataTexto">
            Informe um texto:
            <input type="text" name="texto"><br><br>
            <input type="submit" value="Tratar texto">
        </form>
        
        <%
            if (request.getParameter("texto") != null){
        %>
                <h3>
                <p>Texto original: <%= request.getParameter("texto").toString() %> </p>
                <p>Texto mai�sculo:  <%= request.getAttribute("textoMaiusculo").toString() %> </p>
                <p>Texto min�sculo:  <%= request.getAttribute("textoMinusculo").toString() %> </p>
                </h3>        
        <%
            }
        %>
        
    </body>
</html>