/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.Favorito;
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
public class FavoritoDAO {
      public static int insertFAV(Favorito fav){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Favorito(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
        
            statement.setInt(2, fav.getPregunta());//Pregunta
            statement.setInt(3, fav.getUser().getId());//Usuario
         

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
      
       public static Favorito  MostrarFAVCantidadPregunta(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Favorito(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "U"); // Remplazamos el primer parametro por la opción del procedure
        
            statement.setInt(2, ID);//Pregunta
            statement.setInt(3, 0);//Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int contador = result.getInt(1); //ID
                int Preg = result.getInt(2); //Pregunta
                return new Favorito(contador,Preg);
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
      
        public static List<Favorito>  MostrarFavoritoPregunta(int ID) {
        List<Favorito> fav = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             
             String sql = "call Proc_Favorito(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
        
            statement.setInt(2, ID);//Pregunta
            statement.setInt(3, 0);//Usuario
             ResultSet result = statement.executeQuery();
            while(result.next()) {
             
                int Preg = result.getInt(1); //Pregunta
                boolean isFAV = result.getBoolean(2);
                 int idUser = result.getInt(3); //Usuario
                User usuario = UserDAO.GetUser(idUser);
              
                 fav.add(new Favorito(isFAV, Preg,usuario));
               
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
              return fav;
      
    }
        
          public static int DesmarcarFAV(Favorito fav){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Favorito(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
        
            statement.setInt(2, fav.getPregunta());//Pregunta
            statement.setInt(3, fav.getUser().getId());//Usuario

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
