package com.project.repository;


import com.project.model.vacina.Lote;
import com.project.model.vacina.Frasco;
import com.project.util.DataBaseUtil;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class LoteRepository {
    
    public void inserirLote(Lote lote) throws SQLException {
        
        String sql = "INSERT INTO lote (id_lote, data_validade, quantidade_vacinas) VALUES (?, ?, ?)";

        Connection connection = DataBaseUtil.getConnection();
        
        inserirLote(lote, connection);
    }

    public void inserirLote(Lote lote, Connection connection) throws SQLException {

        String sql = "INSERT INTO lote (id_lote, vacina_id_vacina, data_validade) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, lote.getIdLote());
            preparedStatement.setInt(2, lote.getIdVacina());
            preparedStatement.setDate(3, Date.valueOf(lote.getDataValidade()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }

    public Lote bucarLotePorID(String id_lote) throws SQLException {
        String sql = "SELECT id_lote, vacina_id_vacina, data_validade FROM lote WHERE id_lote = ?";

        Lote lote = null;


        try(Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1,id_lote);

            try(ResultSet resultadoBusca = preparedStatement.executeQuery()) {
                if(resultadoBusca.next()) {
                    lote = new Lote(resultadoBusca.getString("id_lote"), resultadoBusca.getInt("vacina_id_vacina"),
                    resultadoBusca.getDate("data_validade").toLocalDate());
                }
            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();

                throw e;
            }
        }
        return lote;
    }
    



    public List<Lote> buscarTodosLotes() throws SQLException {
        
        String sql = "SELECT id_lote, vacina_id_vacina, data_validade FROM lote";

        List<Lote> lotes = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                while (resultadoBusca.next()) {
                    Lote lote = new Lote(resultadoBusca.getString("id_lote"), resultadoBusca.getInt("vacina_id_vacina"), resultadoBusca.getDate("data_validade").toLocalDate());
                    lotes.add(lote);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return lotes;
    }

}