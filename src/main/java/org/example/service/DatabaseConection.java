package org.example.service;

import javax.management.Query;
import java.sql.*;

/**
 * Esta clase se encarga de la conexión a la base de datos.
 * La conexión se realiza mediante el uso de JDBC.
 * La base de datos será MySQL.
 * Esta clase será un Singleton.
 */
public class DatabaseConection {


    private static DatabaseConection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/escuela_DB";
    private static final String USER ="root";
    private static final String PASSWORD ="1234jose";
    private Connection connection;

    private DatabaseConection(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + URL + " ... Ok");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DatabaseConection getInstance(){
        if (instance == null) {
            instance = new DatabaseConection();
        }
        return instance;
    }

    /**
     * Metodo que permite hacer una consulta a la base de datos.
     */

    public boolean iniciarSesion(String query) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
