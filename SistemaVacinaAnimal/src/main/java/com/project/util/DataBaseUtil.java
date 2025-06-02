package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root"; // SUBSTITUA PELO SEU USUÁRIO
    private static final String PASSWORD = "admin";   // SUBSTITUA PELA SUA SENHA

    public static Connection getConnection() throws SQLException {
        // Opcional: Registrar o driver para versões mais antigas do JDBC.
        // try {
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        //     throw new SQLException("Driver MySQL JDBC não encontrado.", e);
        // }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
