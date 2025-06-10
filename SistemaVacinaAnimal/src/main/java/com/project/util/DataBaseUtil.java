package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static String URL = "jdbc:mysql://localhost:3306/clinica?useTimezone=true&serverTimezone=UTC";
    private static String USER = "root";
    private static String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
