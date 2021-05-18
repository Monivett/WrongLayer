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

                        <select  name ="Categorias" id="Categorias">
                            <option> Categoria</option>
                              <%
                                  
                                if(categorias!=null)
                                for(Categoria categoria: categorias){%>  
                                <option value ="<%=categoria.getId()%>">
                                             
                                  <%= categoria.getName()%>
                                   
                                </option>
                            <% } %> 
                   
                        </select>
               
