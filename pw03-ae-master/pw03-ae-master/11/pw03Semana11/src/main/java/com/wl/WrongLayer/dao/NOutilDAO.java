/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.NOutil;
import com.wl.WrongLayer.models.User;
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
public class NOutilDAO {
        public static int insertNOUtil(NOutil no){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_NOUtil(?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
         
            statement.setInt(3, no.getPregunta());//Pregunta
            statement.setInt(4, no.getUser().getId());//Usuario
         

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
        
        public static NOutil  MostrarNOUtilCantidadPregunta(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
                  String sql = "call Proc_NOUtil(?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "U"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
            statement.setInt(3, ID);//Pregunta
            statement.setInt(4, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int contador = result.getInt(1); //ID
                int Preg = result.getInt(2); //Pregunta
                return new NOutil(contador,Preg);
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
           
        public static List<NOutil>  MostrarNOUtilPregunta(int ID) {
        List<NOutil> NOutil = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
             String sql = "call Proc_NOUtil(?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
            statement.setInt(3, ID);//Pregunta
            statement.setInt(4, 0);//Usuario
             ResultSet result = statement.executeQuery();
            while(result.next()) {
             
                int Preg = result.getInt(1); //Pregunta
                boolean isNOUtil = result.getBoolean(2);
                 int idUser = result.getInt(3); //Usuario
                User usuario = UserDAO.GetUser(idUser);
              
                 NOutil.add(new NOutil(isNOUtil, Preg,usuario));
               
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
              return NOutil;
      
    }
           
        public static int DesmarcarNOUtil(NOutil NOutil){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
             String sql = "call Proc_NOUtil(?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
            statement.setInt(3, NOutil.getPregunta());//Pregunta
            statement.setInt(4, NOutil.getUser().getId());//Usuario

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
        
        //---------------------------RESPUESTA---------------
             
        public static int insertNOUtilRespuestas(NOutil no){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_NOUtilR(?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
           
            statement.setInt(3, no.getPregunta());//Pregunta
             statement.setInt(4, no.getRespuesta());//Respuesta
            statement.setInt(5, no.getUser().getId());//Usuario
         
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
        
           public static NOutil  MostrarNOUtilCantidadRespuesta(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
                  String sql = "call Proc_NOUtil(?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "U"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
            statement.setInt(3, ID);//Pregunta
            statement.setInt(4, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int contador = result.getInt(1); //ID
                int Preg = result.getInt(2); //Pregunta
                return new NOutil(contador,Preg);
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
        
          public static List<NOutil>  MostrarNOUtilRespuesta(int ID) {
        List<NOutil> NOutil = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
           String sql = "call Proc_NOUtilR(?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
           
            statement.setInt(3,ID);//Pregunta
             statement.setInt(4, 0);//Respuesta
            statement.setInt(5, 0);//Usuario
             ResultSet result = statement.executeQuery();
            while(result.next()) {
                int resp = result.getInt(1); //Respuesta
                int Preg = result.getInt(2); //Pregunta
                boolean isNOUtil = result.getBoolean(3);
                 int idUser = result.getInt(4); //Usuario
                User usuario = UserDAO.GetUser(idUser);
              int contador = result.getInt(5); //Respuesta
                 NOutil.add(new NOutil(contador,isNOUtil, Preg,resp,usuario));
               
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
              return NOutil;
      
    }
          
          public static int DesmarcarNOUtilRespuesta(NOutil NOutil){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
                
           String sql = "call Proc_NOUtilR(?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
            statement.setBoolean(2, true); // El tercero por el bool  
           
            statement.setInt(3,NOutil.getPregunta());//Pregunta
             statement.setInt(4, 0);//Respuesta
            statement.setInt(5, 0);//Usuario

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
}
