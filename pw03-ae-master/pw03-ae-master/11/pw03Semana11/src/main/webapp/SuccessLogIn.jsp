<%-- 
    Document   : SuccessLogIn
    Created on : 12/11/2020, 08:45:30 PM
    Author     : magoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>ID: <%= session.getAttribute("ID")%></h2>
        <h2>Userame: <%= session.getAttribute("username")%></h2>
        <form method="post" action="LogOffController">
            <input type="submit" class="btn btn-success" action="Cerrar Sesion">
        </form>
    </body>
</html>
