/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.models.News;
import com.pw.pw03semana11.utils.DbConnection;
import com.wl.WrongLayer.models.Categoria;
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
         public static int InsertarPregunta(News news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL Proc_Pregunta(?, ?, ?, ?,?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
             statement.setString(1, "I");
             statement.setInt(2, 0);
             statement.setString(3, news.getTitle());
             statement.setString(4, news.getDescription());
             statement.setInt(5, news.getCategory().getId());
             statement.setString(6, news.getImagePath());
             statement.setInt(7, 34);
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
          public static List<News> MostrarPreguntas() {
        List<News> Preguntas = new ArrayList<>();
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
                Preguntas.add(new News(id, title, description, pathImage, category));
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

        
}
