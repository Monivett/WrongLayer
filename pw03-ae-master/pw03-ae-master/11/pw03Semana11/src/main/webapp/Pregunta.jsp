<%-- 
    Document   : Pregunta
    Created on : 11/05/2021, 09:22:18 AM
    Author     : monic
--%>

<%@page import="com.wl.WrongLayer.models.Favorito"%>
<%@page import="com.wl.WrongLayer.models.NOutil"%>
<%@page import="com.wl.WrongLayer.models.Util"%>
<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="com.wl.WrongLayer.models.Pregunta"%>
<%@page import="com.wl.WrongLayer.models.User"%>
<%@page import="com.wl.WrongLayer.models.Respuestas"%>
<%@page import="java.util.List"%>


<% 
    //MUESTRA LA PREGUNTA SELECCIONADA
    Pregunta preguntas = (Pregunta)request.getAttribute("preguntas");
    //MUESTRA LOS USUARIOS
    User user =(User)request.getAttribute("usuario");
    
    Util utilC =(Util)request.getAttribute("utilc");
     NOutil NOutilC =(NOutil)request.getAttribute("NOutilC");
     Favorito favC =(Favorito)request.getAttribute("FAVC");
      List<Respuestas> TOTALrespuestas = (List<Respuestas>)request.getAttribute("TOTALrespuestas");
      List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
     List<Respuestas> respuestas = (List<Respuestas>)request.getAttribute("respuestas");
     
       List<Util> Util = (List<Util>)request.getAttribute("Util");
       List<NOutil> NOuUtil = (List<NOutil>)request.getAttribute("NOUtil");
       List<Favorito> fav = (List<Favorito>)request.getAttribute("FAV");
       
         boolean MarcadoUtil = false;
         boolean MarcadoNOUtil = false;
         boolean MarcadoFAV = false;
         
         //UTIL Y NO UTIL DE RESPUESTAS
         List<Util> Utilr = (List<Util>)request.getAttribute("UtilR");
         Util utilCR =(Util)request.getAttribute("utilcR");
         List<NOutil> NoutilR = (List<NOutil>)request.getAttribute("NUtilR");
         NOutil NoUtilR =(NOutil)request.getAttribute("NoUtilR");
         boolean MarcadoUtilR = false;
         boolean MarcadonoUtilR = false;
         
                                  int cantidadpregutnas = 0;
                                     int paginacion = 1;
                                     int pregur = 10;
   for(Respuestas P: TOTALrespuestas){ 
      cantidadpregutnas++;
       if(cantidadpregutnas >=pregur){
                                         paginacion = paginacion+1; 
                                         pregur = pregur+10;
       }
   }
  
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Pregunta</title>
    <link rel="shortcut icon" href="IMG/Logo.png" type="image/x-icon">
    <link rel="stylesheet" href="Boostrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/Pregunta_1.css">
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
             <button onclick="location.href='PreguntasPrincipal';" type="submit">PantallaPrincipal</button>
                 <jsp:include page= "navbar.jsp"/>
              <%  if (session.getAttribute("username") == null) {%>
           <button onclick="location.href='LogInController';" type="submit">Iniciar Sesión</button>
          <button onclick="location.href='RegistroController';" type="submit">Registrarse</button>
             <% }else{%>
               <form id="BTN_CerrarSession" action ="PreguntasPrincipal" method="POST">
                    <button onclick="location.href='PreguntasPrincipal';" type="submit">Cerrar Sesión</button>
             </form>
           
             <%}%>
        </div>
    </nav>
<div class="usuario">
  
        <%  if (session.getAttribute("username") != null) {%>
          <img src="<%= session.getAttribute("Foto")%>" width="200" height="200">
      <input type="text" id="user" name="user" value="<%= session.getAttribute("username")%>"  readonly><br><br>
           <button id = "perfil" onclick="location.href='VerUsuarioPreguntaController?id=<%= session.getAttribute("ID_Usuario")%>';" type="submit">Mi perfil</button>   
    <% }else{%>
      <img src="IMG/default.png" width="200" height="200">
 <input type="text" id="user" name="user" value="Invitado" readonly><br><br>
<%}%>
     
   
</div>
    <div class="Cartas">
 <div class=" Pregunta card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Pregunta: </b> <%= preguntas.getPregunta()%>
          <img src="<%= preguntas.getImagePath()%>" class="card-img-top" width="400" height="200">
          <p class="card-text">Descripción: <%= preguntas.getDescription()%></p>
          <p class="card-text">Categoría: <%= preguntas.getCategory().getName()%> </p>
          <p class="card-text">Fecha:  <%= preguntas.getFecha()%></p>
          <a href="VerUsuarioAjeno?id=<%= preguntas.getUser().getId()%>">
               <p class="card-text"><img src="<%= preguntas.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= preguntas.getUser().getUsername()%> </p>
          </a>
         
        
          <div class="puntuacion">
              <p> <b> Puntuación:</b>  </p>
              <!-- Si el usuario esta logeado y es dueño de la pregunta y NO esta suspendido -->
         <%    Object estado = Integer.valueOf(1);
         
                Object IP = Integer.valueOf(preguntas.getUser().getId());
        if(IP.equals(session.getAttribute("ID_Usuario")) && session.getAttribute("username") !=null && estado == session.getAttribute("Estado")  ){%>
                 
                   <b>    <i class="Unlike fas fa-thumbs-down"></i> No útil:</b> <%= NOutilC.getContador()%>
                 <br>
                 <!-- Si el usuario esta logeado y NO es dueño de la pregunta y NO esta suspendido -->
              <%  }else if(session.getAttribute("username") !=null && estado == session.getAttribute("Estado"))  { %>   
                     
            <br>
            <% for(Util ut: Util){
           
                Object User = Integer.valueOf(ut.getUser().getId());
                if( User == (session.getAttribute("ID_Usuario")) &&  preguntas.getId() == ut.getPregunta() ){
               MarcadoUtil = true;
            %>
                <p>Ya marcaste como útil</p>
                 <form action = "DesmarcarUtilPregunta" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
               <button id="BTN_UTIL"onclick="location.href='DesmarcarUtilPregunta';">
                Desmarcar Útil
                </button>  
            </form>
            <%}%>
                  <%}%>
                                 
                                  <% for(NOutil nout: NOuUtil){
           
                Object User = Integer.valueOf(nout.getUser().getId());
                if( User == (session.getAttribute("ID_Usuario")) &&  preguntas.getId() == nout.getPregunta() ){
               MarcadoNOUtil = true;
            %>
              <p>Ya marcaste como NO útil</p>
                   <form action = "DesmarcarNOUtilPregunta" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
               <button id="BTN_DNOUTIL"onclick="location.href='DesmarcarNOUtilPregunta';">
                Desmarcar NO Útil
                </button>  
            </form>
            <%}%>
                  <%}%>
                  
                       
                              <% for(Favorito FAV: fav){
           
                Object User = Integer.valueOf(FAV.getUser().getId());
                if( User == (session.getAttribute("ID_Usuario")) &&  preguntas.getId() == FAV.getPregunta() ){
               MarcadoFAV = true;
            %>
              <p>Ya marcaste como Favorito</p>
                   <form action = "DesmarcarFav" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
               <button id="BTN_NOUTIL"onclick="location.href='DesmarcarFav';">
                Desmarcar Favorito 
                </button>  
            </form>
            <%}%>
                  <%}%>
              
                         <% if (MarcadoUtil == false){%>
            <form action = "UtilController" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
            
                <button id="BTN_UTIL"onclick="location.href='UtilController';">
                Marcar como útil
                <i class="Like fas fa-thumbs-up"></i>
                </button>  
            </form>
             <%}%>
                  
                          <% if (MarcadoNOUtil == false){%>
             
                  <form action = "NOutilController" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
               <button id="BTN_UTIL"onclick="location.href='NOutilController';">
                   Marcar como NO Útil 
                   <i class="Unlike fas fa-thumbs-down"></i>
                </button>  
                </form>
               
                 <%}%>
                   <% if (MarcadoFAV == false){%> 
                    <form action = "FavoritoController" method="POST">
                <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
               <button id="BTN_UTIL"onclick="location.href='UtilController';">
                Marcar Favorito
                 <i class="FAV fas fa-star"></i>
                </button>  
            </form>
                <%}%>
            
                     <%  }%> 
                     <!-- Lo que pueden ver todos -->
         
                 
                 <b>   <i class="Like fas fa-thumbs-up"></i> Útil:</b> <%= utilC.getContador()%> 
                 <br>
               
               
           
                  <b>  <i class="FAV fas fa-star"></i> Favorito:</b>  <%= favC.getContador()%>
            </p>
    
                <br>
                <br>
                     <% if(preguntas.isModificada()== true){%>
                          <p>Esta pregunta fue editada</p>
                                <%}%>           
                <br>
                <br>
                 </div>
        </div>
      </div>
      <br>
      
         
<% for(Respuestas resp: respuestas){
    if(resp.isCorrecta()== true){%>
      <div class=" RespuestaC card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Respuesta Correcta: </b><%= resp.getRespuesta()%> <img src="<%= resp.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
       
          <p class="card-text">Fecha:   <%= resp.getFecha()%></p> 
            <a href="VerUsuarioAjeno?id=<%= resp.getUser().getId()%>">
          <p class="card-text"><img src="<%= resp.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= resp.getUser().getUsername()%></p>
         
          
          </a>
    
        
     
        </div>
          
      </div>
            <%}%>
                  <%}%>
      <br>
         
          <%    if(respuestas!=null)
              for(Respuestas respuesta: respuestas){%>
              <% if(respuesta.isEliminada()== true){%>
                          <h8>Esta respuesta fue Eliminada</h8>
                          <br>
                                <%}else{%>
                                  <br>
      <div class=" Respuestas card" style="width: 950px;">
        
        <div class="card-body">  
        
          <h5 class="card-title"><b>Respuesta: </b><%= respuesta.getRespuesta()%> <img src="<%= respuesta.getImagePath()%>" class="card-img-top" width="400" height="200"></h5>
         
          <p class="card-text">Fecha:  <%= respuesta.getFecha()%></p>
            <a href="VerUsuarioAjeno?id=<%= respuesta.getUser().getId()%>">
               <p class="card-text"><img src="<%= respuesta.getUser().getUrlImage()%>" class="fotouser" width="50" height="50"> Usuario: <%= respuesta.getUser().getUsername()%></p>
          </a>
         
        
          <div class="puntuacion">
              <!<!-- Si el usuario es dueño de la pregunta y NO esta suspendido -->
           <%    
                Object ID = Integer.valueOf(preguntas.getUser().getId());
                 if(ID.equals(session.getAttribute("ID_Usuario"))&& estado == session.getAttribute("Estado")){%>
     
                 <form action="RespuestaCorrectaController" method="POST" " >
                        <input type="text" name="IDR" id="ID" value="<%= respuesta.getId()%>" style="display: none;" >   
                        <input type="text" name="ID_P" value="<%= respuesta.getPreguntas()%>" style="display: none">
                        <button onclick="location.href='RespuestaCorrectaController?id=<%= respuesta.getId()%>" type="submit">
                           Marca como correcta
                        </button>
                         
                              </form> 
                           
          <%}%>
     
                <br>
                <br>
                <% if(respuesta.isModificada()== true){%>
                          <p>Esta respuesta fue editada</p>
                                <%}%>
                 </div>
                           
                  <%       int i = 0;
                 
                      for(Util utR: Utilr){
           int Contador = utR.getContador();
        if(respuesta.getId()==utR.getRespuesta()){
           i = Contador+i;
        }
                Object User = Integer.valueOf(utR.getUser().getId());
                if( User == (session.getAttribute("ID_Usuario")) &&  respuesta.getId() == utR.getRespuesta()&& estado == session.getAttribute("Estado")){
               MarcadoUtilR = true;
            %>
             <p>Ya marcaste como útil</p>
                   <form action = "DesmarcarUtilRespuesta" method="POST">
                            <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
                <input name = "RespuestaID" value="<%= respuesta.getId()%>" style="display: none;">
               <button id="BTN_NOUTIL"onclick="location.href='DesmarcarUtilRespuesta';">
                Desmarcar Util 
                </button>  
            </form>
                   <%}%>
             <%}%>
                 <p>
            <b> Puntuación:</b>  
              <br>
             <b>   <i class="Like fas fa-thumbs-up"></i> Útil:</b> <%= i%> 
               <br>
          
         
            </p>
            <!<!-- Si el usuario esta logeado y NO esta suspendido -->
                 <%  if (session.getAttribute("username") != null && estado == session.getAttribute("Estado")) {%>
                 <% if (MarcadoUtilR == false){%> 
                 <form action = "UtilControllerRespuestas" method="POST">
                    <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
                <input name = "RespuestaID" value="<%= respuesta.getId()%>" style="display: none;">
               <button id="BTN_UTILR"onclick="location.href='UtilControllerRespuestas';">
                Marcar como útil
                <i class="Like fas fa-thumbs-up"></i>
                </button>  
                </form>
               <%}%>
                 <% MarcadoUtilR = false; %> 
                 <%}%>
                                <%       int u = 0;
                      for(NOutil RNO: NoutilR){
           int Contador = RNO.getContador();
        if(respuesta.getId()==RNO.getRespuesta()){
           u = Contador+u;
        }
                Object User = Integer.valueOf(RNO.getUser().getId());
                if( User == (session.getAttribute("ID_Usuario")) &&  respuesta.getId() == RNO.getRespuesta() && estado == session.getAttribute("Estado")){
               MarcadonoUtilR = true;
            %>
             <p>Ya marcaste como NO útil</p>
                   <form action = "DesmarcarNoUtilRespuesta" method="POST">
                            <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
                <input name = "RespuestaID" value="<%= respuesta.getId()%>" style="display: none;">
               <button id="BTN_NOUTIL"onclick="location.href='DesmarcarUtilRespuesta';">
                Desmarcar NO Util  
                </button>  
            </form>
                   <%}%>
             <%}%>
             <!<!-- Si el usuario es dueño de la respuesta y No esta suspendido -->
                <%    
                Object IDR = Integer.valueOf(respuesta.getUser().getId());
                 if(IDR.equals(session.getAttribute("ID_Usuario")) &&session.getAttribute("username") != null && estado == session.getAttribute("Estado")){%>
             
             <p>
                 <b> <i class="Unlike fas fa-thumbs-down"></i> No útil:</b> <%= u%> 
             </p>
                <%  }%>
                <!<!-- Si el usuario esta logeado y esta ACTIVO -->
                    <%  if (session.getAttribute("username") != null && estado == session.getAttribute("Estado")) {%>
                    <% if (MarcadonoUtilR == false){%> 
                       <form action = "NoUtilRespuestaController" method="POST">
                    <input name = "PreguntaID" value="<%= preguntas.getId()%>" style="display: none;">
                <input name = "RespuestaID" value="<%= respuesta.getId()%>" style="display: none;">
               <button id="BTN_UTILR"onclick="location.href='UtilControllerRespuestas';">
                Marcar como NO útil
                <i class="Like fas fa-thumbs-up"></i>
                </button>  
            </form>
                <%}%>
                    <% MarcadonoUtilR = false; %> 
                 <%}%>
        </div>
      </div>
      <br>
            <%}%>
                <%}%> 
                <br>
                
</div>
                <br>

      </div>
      <%  if (session.getAttribute("username") != null && estado == session.getAttribute("Estado")) {%> 
        
          <form id="form" method="POST" action="RespuestasController" enctype="multipart/form-data">
                <div class="Comentario mb-3">
                    <input type="hidden" name="IdPregunta" value="<%=preguntas.getId()%>">
                       
        <label for="exampleFormControlTextarea1" class="txt form-label">Tu Respuesta</label>
        <textarea name="Respuesta"class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        <input type="file" name="archivo"id="archivo">
                   <input type="submit" value="Responder">
      </div>
                </form>  
<% }else if (session.getAttribute("username") == null){%>
      <h1> Inicia Sesión y responde la pregunta</h1>
        <button id = "publicar" onclick="location.href='LogInController';" type="submit">Iniciar Sesión</button>
      
     <%}else{%>
      <h1> Tu cuenta está suspendida comunicate con los administradores de la página</h1>
      <%}%>
                       <section class="paginacion">
                                  <ul>	                             
			      <%  for (int limite=1;limite<=paginacion;limite++){%>  
                              <form method="POST" action ="VerPreguntaController?page=<%= limite%>" >
                                  <input type="text" value="<%= preguntas.getId()%>" name="ID" style="display: none;">
                                  	
                                 <button id="paginacion"onclick="location.href='VerPreguntaCategoria?page=<%= limite%>';" type="submit">
                                       <%= limite%>   
                                   </button>  
                       
                              </form>
                  	            
                                <% 
                                    }%> 
                               
                                 </section>  
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
</body>
<script src="Boostrap/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/2c36e9b7b1.js" crossorigin="anonymous"></script>
</html>