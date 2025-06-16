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

        try (Connection connection)
    }

}
