package com.project.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexaoUtil {
    public static void testarConexao() {
        try (Connection connection = DataBaseUtil.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexão estabelecida.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}