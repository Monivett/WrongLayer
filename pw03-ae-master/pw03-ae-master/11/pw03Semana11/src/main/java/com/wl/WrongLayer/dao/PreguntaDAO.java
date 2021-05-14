/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.models.News;
import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.Categoria;
import com.wl.WrongLayer.models.Pregunta;
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
public class PreguntaDAO {
       //  public static int InsertarPregunta(News news) {
    public static int InsertarPregunta(Pregunta pregunta) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            
            String sql = "CALL Proc_Pregunta(?, ?, ?, ?,?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "I");
             statement.setInt(2, 0); //ID
             statement.setString(3, pregunta.getPregunta());
             statement.setString(4, pregunta.getDescription());
             statement.setInt(5, pregunta.getCategory().getId());
             statement.setString(6, pregunta.getImagePath());
             statement.setInt(7, pregunta.getUser().getId());
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
          public static List<Pregunta> MostrarPreguntas() {
        List<Pregunta> Preguntas = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Pregunta(?,?,?,?,?,?,?)";
                  CallableStatement statement = con.prepareCall(sql);
                  statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
                  statement.setInt(2, 0); // ID
                  statement.setString(3, "0"); // Pregunta
                  statement.setString(4, "0"); // Descripcion
                  statement.setInt(5, 0); //Categoria
                  statement.setString(6, "0"); // Foto
                  statement.setString(7, "0"); // Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                int idCategory = result.getInt(4);
                Categoria category = CategoriaDAO.getCategory(idCategory);
                String pathImage = result.getString(5);
                Preguntas.add(new Pregunta(id, title, description, pathImage, category));
            }
            return Preguntas;
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
        return Preguntas;
    }

         public static Pregunta  MostrarPreguntaID(int ID) {
       
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Pregunta(?,?,?,?,?,?,?)";
                  CallableStatement statement = con.prepareCall(sql);
                  statement.setString(1, "P"); // Remplazamos el primer parametro por la opción del procedure
                  statement.setInt(2, ID); // ID
                  statement.setString(3, "0"); // Pregunta
                  statement.setString(4, "0"); // Descripcion
                  statement.setInt(5, 0); //Categoria
                  statement.setString(6, "0"); // Foto
                  statement.setString(7, "0"); // Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1); //ID
                String title = result.getString(2); //PREGUNTA
                String description = result.getString(3); //DESCRIPCIÓN
                int idCategory = result.getInt(4); //CATEGORIA
                Categoria category = CategoriaDAO.getCategoria(idCategory); 
                String pathImage = result.getString(5); //FOTO
                String Fecha = result.getString(6); //FECHA DE CREACIÓN
                
                int idUser = result.getInt(7); //USUARIO
                User usuario = UserDAO.GetUser(idUser);
                return new Pregunta(id, category, title,pathImage, usuario,description, Fecha);
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
         
           public static List<Pregunta>  MostrarPreguntaUsuario(int ID) {
        List<Pregunta> Preguntas = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
              String sql = "call Proc_Pregunta(?,?,?,?,?,?,?)";
                  CallableStatement statement = con.prepareCall(sql);
                  statement.setString(1, "A"); // Remplazamos el primer parametro por la opción del procedure
                  statement.setInt(2, 0); // ID
                  statement.setString(3, "0"); // Pregunta
                  statement.setString(4, "0"); // Descripcion
                  statement.setInt(5, 0); //Categoria
                  statement.setString(6, "0"); // Foto
                  statement.setInt(7, ID); // Usuario
                  ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1); //ID
                String title = result.getString(2); //PREGUNTA
                String description = result.getString(3); //DESCRIPCIÓN
                int idCategory = result.getInt(4); //CATEGORIA
                Categoria category = CategoriaDAO.getCategoria(idCategory); 
                String pathImage = result.getString(5); //FOTO
                String Fecha = result.getString(6); //FECHA DE CREACIÓN
                
                int idUser = result.getInt(7); //USUARIO
                User usuario = UserDAO.GetUser(idUser);
                 Preguntas.add(new Pregunta(id, category, title,pathImage, usuario,description, Fecha));
               
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
              return Preguntas;
      
    }

}
