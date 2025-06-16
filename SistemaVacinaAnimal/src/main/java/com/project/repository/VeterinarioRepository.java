package com.project.repository;




import com.project.model.pessoas.Veterinario;
import com.project.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class VeterinarioRepository {
    
    public List<Veterinario> buscarTodos() throws SQLException {

        String sql = "SELECT p.nome, p.cpf, p.telefone, p.email, p.data_nascimento, p.sexo, v.crmv " + "FROM pessoa p JOIN veterinario v ON p.funcionario_crmv = v.crmv";

        List<Veterinario> veterinarios = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultadoBusca = preparedStatement.executeQuery()) {

            while (resultadoBusca.next()) {
                Veterinario veterinario = new Veterinario(
                    resultadoBusca.getString("crmv"),
                    resultadoBusca.getString("nome"),
                    resultadoBusca.getString("cpf"),
                    resultadoBusca.getString("telefone"),
                    resultadoBusca.getString("email"),
                    resultadoBusca.getDate("data_nascimento").toLocalDate(),
                    resultadoBusca.getString("sexo").charAt(0)
                );
                veterinarios.add(veterinario);
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return veterinarios;
    }

}
