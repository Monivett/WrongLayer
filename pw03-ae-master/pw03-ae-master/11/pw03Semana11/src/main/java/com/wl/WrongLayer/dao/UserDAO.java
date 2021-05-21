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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author monic
 */
public class UserDAO {
        
    public static int insertUser(User user){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setString(2, "0"); 
            statement.setString(3, user.getNombre()); // El tercero por la nombres  
            statement.setString(4, user.getAp());
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
    
    
public static User LogInUser (User user){
     Connection con = null;
            try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para hacer Log In
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Login(?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setString(1, user.getUsername());          
            statement.setString(2, user.getPassword());
          
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                 int id = resultset.getInt(1);
                String username = resultset.getString(2);
                String file = resultset.getString(3);
                String nombre = resultset.getString (4);
                String apellido = resultset.getString (5);
                int Edad = resultset.getInt (6);
                String Correo = resultset.getString (7);
                String contraseña = resultset.getString (8);
                String FechaNac = resultset.getString (9);
                 int  Estado = resultset.getInt (10);
                return new User(id, nombre,apellido,FechaNac,Correo,username,contraseña,file,Edad,Estado);
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
        return null;
        
    
}
    
      public static User GetUser (int ID){
     Connection con = null;
            try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
                 
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, ID); //ID
             statement.setString(3, ""); // El tercero por la nombres  
            statement.setString(4, ""); //Apellido
            statement.setString(5, "1973-04-09"); //Fecha de nacimiento
            statement.setString(6, "");//correo
            statement.setString(7, ""); // El septimo por la url de la imagen
            statement.setString(8, "");      //nombre de usuario    
            statement.setString(9, "");// El noveno por la contraseña        
            statement.setInt(10, 1); //Estado: Activo
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
                String file = resultset.getString(3);
                String nombre = resultset.getString (4);
                String apellido = resultset.getString (5);
                String FechaNac = resultset.getString (6);
                String Correo = resultset.getString (7);
                String contraseña = resultset.getString (8);
                String Fechacreacion = resultset.getString (9);
                return new User(id, nombre,apellido,FechaNac,Correo,username,contraseña,file);
                //return new User (id,username,file);
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
        return null;
            
    }
      
       
public static int ModificarUser(User user){
       Connection con = null;
        try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "U"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, user.getId()); 
            statement.setString(3, user.getNombre()); // El tercero por la nombres  
            statement.setString(4, user.getAp());
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

   public static User VerPerfilAjeno (int ID){
     Connection con = null;
            try{
             con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Usuario(?,?,?,?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            
                 
            statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, ID); //ID
             statement.setString(3, ""); // El tercero por la nombres  
            statement.setString(4, ""); //Apellido
            statement.setString(5, "1973-04-09"); //Fecha de nacimiento
            statement.setString(6, "");//correo
            statement.setString(7, ""); // El septimo por la url de la imagen
            statement.setString(8, "");      //nombre de usuario    
            statement.setString(9, "");// El noveno por la contraseña        
            statement.setInt(10, 1); //Estado: Activo
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                int id = resultset.getInt(1);
                String username = resultset.getString(2);
                String file = resultset.getString(3);
                
                return new User(id, username,file);
                //return new User (id,username,file);
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
        return null;
            
    }

  
    Connection con;
    PreparedStatement ps;
    CallableStatement cs;
    ResultSet rs;
    User usu = null;

    public User identificar(User user) {
         Connection con = null;
       
        try {
             con = DbConnection.getConnection();
              String sql = "call Proc_Login(?,?)";
              CallableStatement statement = con.prepareCall(sql);
            cs = con.prepareCall(sql);
            cs.setString(1, user.getUsername());
            cs.setString(2, user.getPassword());
            rs = cs.executeQuery();
            if (rs.next() == true) {
                usu = new User();
               
                usu.setUsername(user.getUsername());
                usu.setPassword(user.getPassword());
                 int id = rs.getInt(1);
                String username = rs.getString(2);
                String file = rs.getString(3);
                String nombre = rs.getString (4);
                String apellido = rs.getString (5);
                int Edad = rs.getInt (6);
                String Correo = rs.getString (7);
                String contraseña = rs.getString (8);
                String FechaNac = rs.getString (9);
                 int  Estado = rs.getInt (10);
                return new User(id, nombre,apellido,FechaNac,Correo,username,contraseña,file,Edad,Estado);
            }
        }       catch (SQLException ex) {
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
        return usu;
    }

    public User selectID(int id) {
        User user = new User();
        String sql = "{CALL selectID(?)}";
        try {
            con = DbConnection.getConnection();
             CallableStatement statement = con.prepareCall(sql);
            cs.setInt(1, id);
               ResultSet resultset = statement.executeQuery();
            while(resultset.next()) { //Mientras el resultSet tenga algo
                 int ID = resultset.getInt(1);
                String username = resultset.getString(2);
                String file = resultset.getString(3);
                String nombre = resultset.getString (4);
                String apellido = resultset.getString (5);
                int Edad = resultset.getInt (6);
                String Correo = resultset.getString (7);
                String contraseña = resultset.getString (8);
                String FechaNac = resultset.getString (9);
                 int  Estado = resultset.getInt (10);
                return new User(ID, nombre,apellido,FechaNac,Correo,username,contraseña,file,Edad,Estado);
            }
        }      catch (SQLException ex) {
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

        return usu;
    }
private static void executeQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

