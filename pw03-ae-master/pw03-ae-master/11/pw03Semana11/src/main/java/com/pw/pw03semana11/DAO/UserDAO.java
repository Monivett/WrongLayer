/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana11.DAO;

import com.pw.pw03semana11.models.User;
import com.pw.pw03semana11.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magoc
 */
public class UserDAO {
//    CREATE TABLE `pw03`.`user` (
//    `iduser` INT NOT NULL AUTO_INCREMENT,
//    `username` VARCHAR(45) NULL,
//    `password` VARCHAR(100) NULL,
//    PRIMARY KEY (`iduser`),
//    UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC) VISIBLE,
//    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

//    USE `pw03`;
//    DROP procedure IF EXISTS `SignInUser`;
//
//    DELIMITER $$
//    USE `pw03`$$
//    CREATE PROCEDURE `SignInUser` (
//    IN `pUsername` varchar(45),
//    IN `pPassword` varchar(100)
//    )
//    BEGIN
//    INSERT INTO `user`
//    (`username`,
//    `password`)
//    VALUES
//    (pUsername,
//    pPassword);
//
//    END$$
//
//    DELIMITER ;
    public static int signInUser(User user) {
        try {
            Connection con = DbConnection.getConnection();
            CallableStatement callable = con.prepareCall("call SignInUser(?,?)");
            callable.setString(1, user.getUserName());
            callable.setString(2, user.getPassword());
            return callable.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
//    USE `pw03`;
//    DROP procedure IF EXISTS `LogInUser`;
//
//    DELIMITER $$
//    USE `pw03`$$
//    CREATE PROCEDURE `LogInUser` (
//    IN `pUsername` varchar(45),
//    IN `pPassword` varchar(100)
//    )
//    BEGIN
//
//    SELECT
//            u.iduser ID,
//        u.username
//     FROM user u
//     WHERE
//            u.username = pUsername
//        AND u.password = pPassword;
//    END$$
//
//    DELIMITER ;
//

    public static User logInUser(User user) {
        try {
            Connection con = DbConnection.getConnection();
            CallableStatement callable = con.prepareCall("call LogInUser(?,?)");
            callable.setString(1, user.getUserName());
            callable.setString(2, user.getPassword());
            ResultSet result = callable.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String username = result.getString("username");
                return new User(id, username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

//    USE `pw03`;
//DROP procedure IF EXISTS `GetUser`;
//
//DELIMITER $$
//USE `pw03`$$
//CREATE PROCEDURE `GetUser` (
//IN `pIduser` int
//)
//BEGIN
//SELECT
//	u.iduser ID,
//    u.username
// FROM user u
// WHERE
//	u.iduser = pIduser;
//END$$
//
//DELIMITER ;
//
    public static User getUser(int idUser) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            CallableStatement callable = con.prepareCall("call GetUser(?)");
            callable.setInt(1, idUser);
            ResultSet result = callable.executeQuery();
            while (result.next()) {
                int id = result.getInt("ID");
                String username = result.getString("username");
                return new User(id, username);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

}
