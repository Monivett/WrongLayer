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

/**
 *
 * @author monic
 */
public class RespuestaDAO {
    public static int InsertarRespuesta(Respuestas respuesta){
           try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Respuesta(?,?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "I"); // Remplazamos el primer parametro por la opción del procedure
            statement.setString(2, "0"); 
             statement.setString(3, respuesta.getRespuesta()); 
             statement.setInt(4, respuesta.getUser().getId()); 
           
          //  statement.setInt(5, respuesta.getNews().getId()); //Bit de eliminar
             statement.setInt(5, 0);
              //statement.setInt(6, respuesta.getNews().getId()); //Pregunta
              statement.setInt(6, 5); //Pregunta
              statement.setString(7, respuesta.getImagePath());
       // con.close();
         return statement.executeUpdate();//Retorna un entero
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return 0;
    }
        public static List<Respuestas> MostrarRespuestas(int ID){
              List<Respuestas> respuestas = new ArrayList<>();
           try{
            Connection con = DbConnection.getConnection();
             // Esta linea prepara la llamada a la base de datos para insertar
             // Cada ? significa un valor a ser remplazado
            String sql = "call Proc_Respuesta(?,?,?,?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
                
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, ID); 
             statement.setString(3, "0"); 
             //statement.setString(4, respuesta.getUser().getId()); 
            statement.setInt(4, 0); // El cuatro por la usuario  
          //  statement.setInt(5, respuesta.getNews().getId()); //Bit de eliminar
             statement.setInt(5, 0);
              //statement.setInt(6, respuesta.getNews().getId()); //Pregunta
              statement.setInt(6, 1); //Pregunta
              statement.setString(7, "");
        ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                String Respuesta = result.getString(2);
                String Fecha = result.getString(3);
                int idUsuario = result.getInt(4);
                User user =UserDAO.GetUser(idUsuario);
                String imagePath = result.getString(6);
                  int pregunta = result.getInt(7);
                  int parent =1;
               
                respuestas.add(new Respuestas(id,Respuesta,user,pregunta, parent,imagePath,Fecha));
            }
        
        }
        catch (SQLException ex) {
         System.out.println(ex.getMessage());
        }
        return null;
     
    }
}
