/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.User;
import com.wl.WrongLayer.models.Util;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author monic
 */
public class UtilDAO {
    //FUNCIONES PARA PONER UTIL EN LA PREGUNTA
        public static int insertUtil(Util util){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, 0);//Respuesta
            statement.setInt(5, util.getPregunta());//Pregunta
            statement.setInt(6, util.getUser().getId());//Usuario

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
      
        public static Util  MostrarUtilCantidadPregunta(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "U"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, 0);//Respuesta
            statement.setInt(5, ID);//Pregunta
            statement.setInt(6, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int contador = result.getInt(1); //ID
                int Preg = result.getInt(2); //Pregunta
                return new Util(contador,Preg);
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
            
        public static List<Util>  MostrarUtilPregunta(int ID) {
        List<Util> util = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
              String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, 0);//Respuesta
            statement.setInt(5, ID);//Pregunta
            statement.setInt(6, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
             
                int Preg = result.getInt(1); //Pregunta
                boolean isUtil = result.getBoolean(2);
                 int idUser = result.getInt(3); //Usuario
                User usuario = UserDAO.GetUser(idUser);
              
                 util.add(new Util(isUtil, Preg,usuario));
               
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
              return util;
      
    }
          
        public static int DesmarcarUtil(Util util){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); //Contador
            statement.setBoolean(3, false); // El tercero por el bool  
            statement.setInt(4, util.getRespuesta());//Respuesta
            statement.setInt(5, util.getPregunta());//Pregunta
            statement.setInt(6, util.getUser().getId());//Usuario

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
     //FUNCIONES PARA PONER UTIL EN LA RESPUESTA
        
          public static int insertUtilR(Util util){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "B"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, util.getRespuesta());//Respuesta
            statement.setInt(5, util.getPregunta());//Pregunta
            statement.setInt(6, util.getUser().getId());//Usuario

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
          
           public static Util  MostrarUtilCantidadRespuesta(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "Z"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4,0);//Respuesta
            statement.setInt(5, ID);//Pregunta
            statement.setInt(6, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int contador = result.getInt(1); //Cantidad
                int Preg = result.getInt(2); //Pregunta
                //int Resp = result.getInt(2); //Respuesta
                
                return new Util(contador,Preg);
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
        
         public static List<Util>  MostrarUtilRespuesta(int ID) {
        List<Util> util = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
              String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "C"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, 0);//Respuesta
            statement.setInt(5, ID);//Pregunta
            statement.setInt(6, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
            
                int resp = result.getInt(1); //Respuesta
                int preg = result.getInt(2); //Pregunta
                boolean isUtil = result.getBoolean(3);
                 int idUser = result.getInt(4); //Usuario
                User usuario = UserDAO.GetUser(idUser);
           int cont = result.getInt(5); //contador
                 util.add(new Util(cont,isUtil, preg,resp,usuario));
               
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
              return util;
      
    }
         
           public static int DesmarcarUtilRespuesta(Util util){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "Y"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); //Contador
            statement.setBoolean(3, false); // El tercero por el bool  
            statement.setInt(4, util.getRespuesta());//Respuesta
            statement.setInt(5, util.getPregunta());//Pregunta
            statement.setInt(6, util.getUser().getId());//Usuario

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
        
             public static List<Util>  MostrarUtilUsuario(int ID) {
        List<Util> util = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
              String sql = "call Proc_Util(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "O"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 1); //Contador
            statement.setBoolean(3, true); // El tercero por el bool  
            statement.setInt(4, 0);//Respuesta
            statement.setInt(5, 0);//Pregunta
            statement.setInt(6, ID);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
            
               
                int preg = result.getInt(1); //Pregunta
                boolean isUtil = result.getBoolean(2);
                 int idUser = result.getInt(3); //Usuario
                User usuario = UserDAO.GetUser(idUser);
           
                 util.add(new Util(isUtil,preg,usuario));
               
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
              return util;
      
    }
        
}
