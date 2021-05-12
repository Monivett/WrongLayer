/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.User;
import com.wl.WrongLayer.models.ValidarLogIn;
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
            statement.setString(7, user.getUrlImage()); // El septimo por la url de la imagen
            statement.setString(8, user.getUsername());          
            statement.setString(9, user.getPassword());// El noveno por la contraseña        
            statement.setInt(10, 1); //Estado: Activo
 
       // con.close();
         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return 0;
       
    }
    
    public static User LogInUser (User user){
     
            try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Login(?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setString(1, user.getUsername());          
            statement.setString(2, user.getPassword());
          
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
                String image = resultset.getString(3);
                
                return new User (id,username,image);
            }
        }
             catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
    
      public static User GetUser (int ID){
     
            try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
                 
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, ID); //ID
             statement.setString(3, ""); // El tercero por la nombres  
            statement.setString(4, "");
            statement.setString(5, "1973-04-09");
            statement.setString(6, "");
            statement.setString(7, ""); // El septimo por la url de la imagen
            statement.setString(8, "");          
            statement.setString(9, "");// El noveno por la contraseña        
            statement.setInt(10, 1); //Estado: Activo
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
                 String file = resultset.getString(3);
                return new User (id,username,file);
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

/*public class UserDAO implements ValidarLogIn{

    @Override
    public int ValidarLogIn(User user) {
       
            try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Login(?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setString(1, user.getUsername());          
            statement.setString(2, user.getPassword());
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
               
            }
        }
             catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return 0;
       
    }
}*/
