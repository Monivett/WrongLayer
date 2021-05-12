<%-- 
    Document   : PantallaPrincipal
    Created on : 10/05/2021, 04:24:16 PM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.pw.pw03semana11.models.News"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     List<Pregunta> preguntas = (List<Pregunta>)request.getAttribute("preguntas");
     session =request.getSession();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wrong Layer</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/PantallaPrincipal_1.css">
</head>

<body>
    <nav>
        <div class="logo">
            <img src="IMG/Logo.png" alt="" height="100" width="100">
         </div>
            <input type="text" name="" id="search" required><span class="barra"></span>
            <label for="">Barra de Búsqueda</label>
            </input>
            <div class="botones">
            <button onclick="location.href='PantallaBusquedaAvanzada.html';" type="submit">Búsqueda Avanzada</button>
             <jsp:include page= "navbar.jsp"/>
            <button onclick="location.href='CategoriaInicio';" type="submit">Iniciar Sesión</button>
           <button onclick="location.href='CategoriaRegistro';" type="submit">Registrarse</button>
       </div>
    </nav>
   
<div class="usuario">
   
     <img src="<%= session.getAttribute("Foto")%>" width="200" height="200">
    <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>" value="<%= session.getAttribute("ID_Usuario")%>" readonly><br><br>
    <button id = "perfil" onclick="location.href='Perfil.html';" type="submit">Mi Perfil</button>
</div>
<div class="preguntas">
   <h1>Preguntas Recientes</h1>
    <%
                                  
                                if(preguntas!=null)
                                for(Pregunta pregunta: preguntas){%> 
                                <a name = "pregunta" href="VerPreguntaController?id=<%= pregunta.getId()%>"> <%= pregunta.getPregunta()%></a>
                                <br></br>

   <%}%>

</div>
<div class="Publicar">
    <h1>¿Tienes una duda? Publica tu pregunta</h1>
    <button id = "publicar" onclick="location.href='CategoriaController';" type="submit">Publicar Pregunta</button>
 
</div>
    <footer>
       
              <h4>Categorías</h4>
           
        
    </footer>
</body>

</html>
