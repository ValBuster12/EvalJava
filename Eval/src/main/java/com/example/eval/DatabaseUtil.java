package com.example.eval;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/e6358u_vehicules_db";
    private static final String USER = "e6358u"; // Remplacez par votre nom d'utilisateur MySQL
    private static final String PASSWORD = "32320420"; // Remplacez par votre mot de passe MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
