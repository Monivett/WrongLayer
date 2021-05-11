/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw03semana11.utils;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author magoc
 */
public class DbConnection {
    // Creamos el objeto conexion
    private static final BasicDataSource dataSource = new BasicDataSource();

    // Inicializamos la conexion
    static {
        // Tipo de Driver, este es el de mysql
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // La URL a la conexion, especificando que es de mysql
        // la ruta que es localhost puerto 3306
        // el nombre de la base de datos que es pwDB
        // lo demas son parametros para que no tengan problemas con zonas horarias
        dataSource.setUrl("jdbc:mysql://localhost:3306/wronglayer?useUnicode=true&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        // El nombre de usuario de su conexion
        dataSource.setUsername("root");
        // La contraseña del usuario de su conexion
        dataSource.setPassword("");
        // dataSource.setMaxIdle(0);
        // dataSource.setMaxActive(100);
    }

    /**
     * *
     * Metodo para obtener la conexion
     *
     * @return Conexion a Base de datos
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * Metodo para cerrar la conexion
     *
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        dataSource.close();
    }
}
