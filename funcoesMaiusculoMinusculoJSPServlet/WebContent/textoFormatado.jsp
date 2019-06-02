<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tratamento de textos</title>
    </head>
    <body>
        <h2>Tratamento para texto longos</h2>
        
        <h3>
        <p>Texto original: <%= request.getParameter("texto").toString() %> </p>
        <p>Texto maiúsculo:  <%= request.getAttribute("textoMaiusculo").toString() %> </p>
        <p>Texto minúsculo:  <%= request.getAttribute("textoMinusculo").toString() %> </p>
        </h3>
    </body>
</html>