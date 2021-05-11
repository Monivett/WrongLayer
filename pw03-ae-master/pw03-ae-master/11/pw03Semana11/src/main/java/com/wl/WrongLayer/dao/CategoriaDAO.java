/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wl.WrongLayer.dao;

import com.pw.pw03semana11.DAO.*;

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
 * @author magoc
 */
public class CategoriaDAO {


    public static List<Categoria> getCategories() {
        List<Categoria> categories = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "call Proc_Categoria(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); 
            statement.setString(3, "0"); // El tercero por la nombres  
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int order = 1;
                int parent = 1;
                categories.add(new Categoria(id, name, order, parent));
            }

            return categories;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categories;
    }
    
    
//    USE `pw03`;
//DROP procedure IF EXISTS `GetCategory`;
//
//DELIMITER $$
//USE `pw03`$$
//CREATE PROCEDURE `GetCategory` (
//IN `pIdcategory` int
//)
//BEGIN
//
//SELECT `category`.`idcategory`,
//    `category`.`name`,
//    `category`.`order`,
//    `category`.`parent`
//FROM `pw03`.`category`
//WHERE `category`.`idcategory` = pIdcategory;
//
//END$$
//
//DELIMITER ;

    public static Categoria getCategory(int idCategory) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
             String sql = "call Proc_Categoria(?,?,?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S"); // Remplazamos el primer parametro por la opción del procedure
            statement.setInt(2, 0); 
            statement.setString(3, "0"); // El tercero por la nombres  
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int order = result.getInt(3);
                int parent = result.getInt(4);
                return new Categoria(id, name, order, parent);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

}
