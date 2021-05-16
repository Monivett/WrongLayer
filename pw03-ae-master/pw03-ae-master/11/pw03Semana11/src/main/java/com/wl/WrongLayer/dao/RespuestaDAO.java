/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.models.News;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Respuestas;
import com.wl.WrongLayer.models.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monic
 */
public class RespuestaDAO {
    public static int InsertarRespuesta(Respuestas respuesta){
 Connection con = null;
        try {
            con = DbConnection.getConnection();
            
            String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "I");//OPCION
             statement.setInt(2, 0); //ID
             statement.setString(3, respuesta.getRespuesta());//RESPUESTA
             statement.setInt(4, respuesta.getUser().getId());//USUARIO
             statement.setInt(5, respuesta.getPreguntas());//PREGUNTA
             statement.setString(6, respuesta.getImagePath());
            
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
        public static List<Respuestas> MostrarRespuestas(int ID){
              List<Respuestas> respuestas = new ArrayList<>();
              Connection con = null;
           try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); //ID DE LA RESPUESTA
             statement.setString(3, null); //RESPUESTA
             statement.setInt(4, 0);//USUARIO
             statement.setInt(5, ID);//ID DE PREGUNTA
             statement.setString(6, null);//FOTO
           
        ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                String Respuesta = result.getString(2);
                String Fecha = result.getString(3);
                int idUsuario = result.getInt(4);
                User user =UserDAO.GetUser(idUsuario);
                boolean Borro = result.getBoolean(5);
                String imagePath = result.getString(6);
                int pregunta = result.getInt(7);
                boolean Mod = result.getBoolean(8);
                boolean Correct=result.getBoolean(9);
         
              respuestas.add(new Respuestas(id,Respuesta,user,pregunta,imagePath,Fecha,Mod,Borro,Correct));
            }
        
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
                finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return respuestas;
     
    }
        
        public static List<Respuestas> MostrarRespuestasUsuario(int ID){
               Connection con = null;
              List<Respuestas> respuestas = new ArrayList<>();
           try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); //ID DE LA PREGUNTA
             statement.setString(3, null); //RESPUESTA
             statement.setInt(4, ID);//USUARIO
             statement.setInt(5, 0);//PREGUNTA
             statement.setString(6, null);//IMAGEN
            
        ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                String Respuesta = result.getString(2);
                String Fecha = result.getString(3);
                int idUsuario = result.getInt(4);
                User user =UserDAO.GetUser(idUsuario);
                boolean Borro = result.getBoolean(5);
                String imagePath = result.getString(6);
                  int pregunta = result.getInt(7);
                boolean Mod = result.getBoolean(8);
             
                 boolean Correct=false;
                respuestas.add(new Respuestas(id,Respuesta,user,pregunta,imagePath,Fecha,Mod,Borro,Correct));
            }
        
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
                        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return respuestas;
     
    }
        
          public static Respuestas  MostrarRespuestasEditar(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "C"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, ID); 
             statement.setString(3, null); 
          
             statement.setInt(4, 0);//USUARIO
             statement.setInt(5, 0);//PREGUNTA
             statement.setString(6, null);//Pregunta
          
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                     int id = result.getInt(1);
                String Respuesta = result.getString(2);
                String Fecha = result.getString(3);
                int idUsuario = result.getInt(4);
                User user =UserDAO.GetUser(idUsuario);
                String imagePath = result.getString(6);
                  int pregunta = result.getInt(7);
                 
         
                return new Respuestas(id,Respuesta,user,pregunta,imagePath,Fecha);
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
          
      
    }
        
         public static int  EditarRespuesta(Respuestas respuesta) {
        Connection con = null;
       try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "U");//OPCION
             statement.setInt(2, respuesta.getId()); //ID
             statement.setString(3, respuesta.getRespuesta());//RESPUESTA
             statement.setInt(4,0);//USUARIO
             statement.setInt(5, 0);//PREGUTNA
             statement.setString(6, respuesta.getImagePath());
           
       // con.close();
         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
                               finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return 0;
      
    }
         
    public static int  EliminarRespuesta(Respuestas respuesta) {
        Connection con = null;
       try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
             String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "E");//OPCION
             statement.setInt(2, respuesta.getId()); //ID
             statement.setString(3, null);//RESPUESTA
             statement.setInt(4,0);//USUARIO
             statement.setInt(5, 0);//PREGUTNA
             statement.setString(6, null);;        
           
 
       // con.close();
         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
             finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return 0;
      
    }
    
     public static int  RespuestaCorrecta(Respuestas respuesta) {
        Connection con = null;
       try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
             String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "Z");//OPCION
             statement.setInt(2, respuesta.getId()); //ID
             statement.setString(3, null);//RESPUESTA
             statement.setInt(4,0);//USUARIO
             statement.setInt(5, respuesta.getPreguntas());//PREGUTNA
             statement.setString(6, null);      

         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
             finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return 0;
      
    }
         
      public static Respuestas  MostrarCorrecta(Respuestas respuesta) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL Proc_Respuesta(?, ?, ?, ?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "X");//OPCION
             statement.setInt(2, respuesta.getId()); //ID
             statement.setString(3, null);//RESPUESTA
             statement.setInt(4,0);//USUARIO
             statement.setInt(5, respuesta.getPreguntas());//PREGUTNA
             statement.setString(6, null);;      
          
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                     int id = result.getInt(1);
                String Respuesta = result.getString(2);
                String Fecha = result.getString(3);
                int idUsuario = result.getInt(4);
                User user =UserDAO.GetUser(idUsuario);
                String imagePath = result.getString(6);
                  int pregunta = result.getInt(7);
                 
         
                return new Respuestas(id,Respuesta,user,pregunta,imagePath,Fecha);
            }
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
          
      
    }
}
