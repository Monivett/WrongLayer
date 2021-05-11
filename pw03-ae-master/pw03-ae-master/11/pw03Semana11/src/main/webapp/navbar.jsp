<%-- 
    Document   : navbar
    Created on : 19/11/2020, 07:35:40 PM
    Author     : magoc
--%>



<%@page import="com.wl.WrongLayer.models.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
     List<Categoria> categorias = (List<Categoria>)request.getAttribute("Categories");
%>

 <nav>
                    <div class="logo">
                        <img src="IMG/Logo.png" alt="" height="100" width="100">
                     </div>
                        <input type="text" name="" id="search" required><span class="barra"></span>
                        <label for="">Barra de Búsqueda</label>
                        </input>
                        <div class="botones">
                        <button onclick="location.href='navbar.jsp';" type="submit">Búsqueda Avanzada</button>
                        <select  name ="Categorias" id="Categorias">
                            
                              <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <option value ="<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   
                                </option>
                            <% } %> 
                   
                        </select>
                        <button onclick="location.href='PantallaInicio.jsp';" type="submit">Iniciar Sesión</button>
                        <button onclick="location.href='PreguntasPrincipal';" type="submit">Pantalla Principal</button>
                        <button onclick="location.href='Registro.jsp';" type="submit">Registrarse</button>
                   </div>
                </nav>
