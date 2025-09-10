package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:ucanaccess://D:/Uni/java/Lab12.accdb";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}