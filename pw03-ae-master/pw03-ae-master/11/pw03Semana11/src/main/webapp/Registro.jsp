<%-- 
    Document   : Registro
    Created on : 9/05/2021, 08:36:11 PM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>

<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
%>

<!DOCTYPE html>

<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="CSS/Registro.css">

</head>

<body>

    <nav>
        <div class="logo">
            <img src="IMG/Logo.png" alt="" height="100" width="100">
        </div>
           <form action = "NavegacionController" method = "POST" id = Nav>
                         <input type="text" name="navegacion" id="search" required><span class="barra"></span>
                        <label for="">Barra de Búsqueda</label>
                        </input>
                        <button onclick="location.href='NavegacionController';" id="nav"type="submit" style="display: none;"></button>
                    </form>
         <div class="botones">
           
      
                  <select  name ="Categorias" id="Categorias">
                      <option>Categoria</option>
                              <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <option value ="<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   
                                </option>
                            <% } %> 
                   
                        </select>
            <button onclick="location.href='PantallaBusquedaAvanzada.html';" class ="BTN_BUSQEUDA"type="submit">Búsqueda Avanzada</button>
             <button onclick="location.href='LogInController';" type="submit">Iniciar Sesión</button>
            <button onclick="location.href='PreguntasPrincipal';" class="BTN_PRINCIPAL"type="submit">PantallaPrincipal</button>
        </div>
           
    
    </nav>
    <h2>Foto de usuario</h2>
    <div id="usuarioFoto" class="usuarioFoto">

    </div>

    <h1> REGISTRO </h1>
   
    <form action="RegistroController" method="POST"  enctype="multipart/form-data" id="registro"  >
        <p>Nombre(s):</p>
        <p>Apellidos:</p>
        <p>Fecha de Nacimiento:</p>
        <p>Correo: </p>
        <p>Usuario: </p>
        <p>Contraseña: </p>
        <p>Confirmar Contraseña: </p>
        <p>Imagen: </p>

        <!--NOMBRE-->
        <div class="GrupoInputNombre">
            <input type="text" id="nombre" placeholder="Nombre(s)" name="Nombres" onkeypress="return SoloLetras(event);"
                required>
        </div>
        <!--APELLIDO-->
        <input type="text" id="apellido" placeholder="Apellidos" name="Ap" onkeypress="return SoloLetras(event);"
            required>
        <!--FECHA DE NACIMIENTO-->
        <div class="GroupInputFecha">
            <input type="date" id="fechanacimiento" name="FechaNac" required>
            <p class="ErrorFecha" id="ErrorFecha">La fecha NO debe ser después de la actual </p>
        </div>
        <!--CORREO-->

        <div class="GrupoInputEmail">
            <input type="email" id="correo" placeholder="Correo" name="email" required>
            <p class="ErrorMail">El correo ES </p>
        </div>

        <!--USUARIO-->
        <div class="GrupoInputUser">
            <input type="text" id="usuario" placeholder="Nombre de Usuario" name="username" required>
            <p class="ErrorUser">El usuario debe de ser único</p>
        </div>

        <!--CONTRASEÑA-->
        <div class="GrupoInputContra">
            <input type="password" id="contraseña" placeholder="Contraseña" name="password" minlength="8" required>
            <p class="ErrorContra" id="ErrorContra">Contraseña débil: La contraseña debe de tener:Mayúsculas,
                minúsculas,números y signos especiales </p>
        </div>

        <!--CONFIRMAR CONTRASEÑA-->
        <div class="GrupoInputContra2" id="GrupoInputContra2">
            <input type="password" id="confirmcontraseña" placeholder="Confirmar Contraseña" name="confirmcontra"
                minlength="8" required>
            <p class="ErrorContra2" id="ErrorContra2">Ambas contraseñas tienen que ser iguales</p>
        </div>
        <!--SUBIR FOTO-->
        <input type="file" id="foto" name="image" required>

        <div class="BTN_REGISTRAR">
            <input  type="submit" id="BTN_REGISTRAR" value="Registrarse" />

        </div>

    </form>

</body>

   <footer>
        <h4> <b>Categorias: </b></h4>
           <h4>
        <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                          
                           °      <%= categoria.getName()%> &nbsp

                            <% } %> 
   </h4>
    </footer>
<script src="JAVASCRIPT/Registro.js"></script>


</html>
