<%-- 
    Document   : PantallaPrincipal
    Created on : 10/05/2021, 04:24:16 PM
    Author     : monic
--%>

<%@page import="com.pw.pw03semana11.models.News"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     List<News> preguntas = (List<News>)request.getAttribute("preguntas");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wrong Layer</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/PantallaPrincipal.css">
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
            <select>
                <option>Categoría 1</option>
                <option>Categoría 2</option>
                <option>Categoría 3</option>
                <option>Categoría 4</option>
                <option>Categoría 5</option>
            </select>
            <button onclick="location.href='PantallaInicio.html';" type="submit">Iniciar Sesión</button>
            <button onclick="location.href='Registro.html';" type="submit">Registrarse</button>
       </div>
    </nav>
   
<div class="usuario">
    
    <input type="text" id="user" name="user" value="" readonly><br><br>
    <button id = "perfil" onclick="location.href='Perfil.html';" type="submit">Mi Perfil</button>
</div>
<div class="preguntas">
   <h1>Preguntas Recientes</h1>
    <%
                                  
                                if(preguntas!=null)
                                for(News pregunta: preguntas){%> 
                                <a href="Publicar.jsp"> <%= pregunta.getTitle()%></a>
                                <br></br>

   <%}%>

</div>
<div class="Publicar">
    <h1>¿Tienes una duda? Publica tu pregunta</h1>
    <button id = "publicar" onclick="location.href='Publicar.html';" type="submit">Publicar Pregunta</button>
 
</div>
    <footer>
       
              <h4>Categorías</h4>
           
        
    </footer>
</body>

</html>
