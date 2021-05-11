/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana11.DAO;

import com.pw.pw03semana11.models.Commentary;
import com.pw.pw03semana11.models.User;
import com.pw.pw03semana11.utils.DbConnection;
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
public class CommentaryDAO {

//CREATE TABLE `commentary` (
//  `idcommentary` int NOT NULL AUTO_INCREMENT,
//  `content` text,
//  `idUser` int DEFAULT NULL,
//  `idNews` int DEFAULT NULL,
//  `parent` int DEFAULT NULL,
//  PRIMARY KEY (`idcommentary`),
//  UNIQUE KEY `idcommentary_UNIQUE` (`idcommentary`),
//  KEY `fk_news_commentary_idx` (`idNews`),
//  KEY `fk_user_commentary_idx` (`idUser`),
//  CONSTRAINT `fk_news_commentary` FOREIGN KEY (`idNews`) REFERENCES `news` (`idNews`),
//  CONSTRAINT `fk_user_commentary` FOREIGN KEY (`idUser`) REFERENCES `user` (`iduser`)
//) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
//    USE `pw03`;
//DROP procedure IF EXISTS `InsertCommentary`;
//
//DELIMITER $$
//USE `pw03`$$
//CREATE PROCEDURE `InsertCommentary` (
//IN `pContent` text,
//IN `pIdUser` int,
//IN `pIdNews` int,
//IN `pParent` int
//)
//BEGIN
//INSERT INTO `pw03`.`commentary`
//(`content`,
//`idUser`,
//`idNews`,
//`parent`)
//VALUES
//(pContent,
//pIdUser,
//pIdNews,
//pParent);
//END$$
//
//DELIMITER ;
//
    public static int insertCommentary(Commentary element) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL InsertCommentary(?,?,?,?);";
            CallableStatement statement = con.prepareCall(sql);

            statement.setString(1, element.getContent());
            statement.setInt(2, element.getUser().getId());
            statement.setInt(3, element.getIdNews());
            statement.setInt(4, element.getParent());

            return statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

//    USE `pw03`;
//DROP procedure IF EXISTS `GetCommnetariesByNews`;
//
//DELIMITER $$
//USE `pw03`$$
//CREATE PROCEDURE `GetCommnetariesByNews` (
//IN `pIdNews` int)
//BEGIN
//SELECT `commentary`.`idcommentary`,
//    `commentary`.`content`,
//    `commentary`.`idUser`,
//    `commentary`.`idNews`,
//    `commentary`.`parent`
//FROM `pw03`.`commentary`
//WHERE `commentary`.`idNews` = pIdNews;
//END$$
//
//DELIMITER ;
    public static List<Commentary> getCommentariesByNew(int idNew) {
        List<Commentary> commentaries = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL GetCommnetariesByNews(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNew);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                String content = result.getString(2);
                int idUser = result.getInt(3);
                int idNews = result.getInt(4);
                int parent = result.getInt(5);
                User user = UserDAO.getUser(idUser);
                commentaries.add(new Commentary(id, content, user, idNews, parent));
            }
            return commentaries;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return commentaries;
    }

//    USE `pw03`;
//DROP procedure IF EXISTS `DeleteCommentary`;
//
//DELIMITER $$
//USE `pw03`$$
//CREATE PROCEDURE `DeleteCommentary` (
//IN `pIdcommentary` int)
//BEGIN
//	DELETE FROM `pw03`.`commentary`
//WHERE `commentary`.`idcommentary` = pIdcommentary;
//END$$
//
//DELIMITER ;
//

    public static int deleteCommentary(int id) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL DeleteCommentary(?)";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentaryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return 0;
    }
    
}
