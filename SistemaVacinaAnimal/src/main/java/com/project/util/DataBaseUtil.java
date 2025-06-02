package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root"; // SUBSTITUA PELO SEU USUÁRIO
    private static final String PASSWORD = "admin";   // SUBSTITUA PELA SUA SENHA

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
