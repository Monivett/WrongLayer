/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author monic
 */
public class UserDAO {
        
    public static int insertUser(User user){
       
        try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setString(2, "0"); 
            statement.setString(3, user.getNombre()); // El tercero por la nombres  
            statement.setString(4, user.getApellido());
            statement.setString(5, user.getDate());
            statement.setString(6, user.getEmail());
              // El septimo por la url de la imagen
      
           statement.setString(7, user.getUrlImage());
         
            statement.setString(8, user.getUsername());          
            statement.setString(9, user.getPassword());// El noveno por la contraseña        
            statement.setInt(10, 1);
 
       // con.close();
         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return 0;
       
    }
    
    public static User LogInUser (String user, String password){
     
            try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Login(?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setString(1, user);          
            statement.setString(2, password);
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
                return new User (id,username);
            }
        }
             catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return null;
        
    }

    private static void executeQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
