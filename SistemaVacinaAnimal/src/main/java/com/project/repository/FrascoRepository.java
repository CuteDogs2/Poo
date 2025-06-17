package com.project.repository;


import com.project.model.vacina.Frasco;
import com.project.util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FrascoRepository {


    
    
    public void inserirFrasco(Frasco frasco) throws SQLException {
        //String sql = "INSERT INTO frasco (id_frasco, volume_frasco) VALUES (?, ?)";
        
        try {
            Connection connection = DataBaseUtil.getConnection();

            inserirFrasco(frasco, connection);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        
    }
    


    
    public void inserirFrasco(Frasco frasco, Connection connection) throws SQLException {




        String sql = "INSERT INTO frasco (id_frasco, volume_frasco, lote_id_lote) VALUES (?, ?, ?)";
        


        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, frasco.getIdFrasco());
            preparedStatement.setFloat(2, frasco.getVolumeFrasco());
            preparedStatement.setString(3, frasco.getIdLote());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            if (connection != null && !connection.isClosed()) {
                connection.rollback(); // Rollback em caso de erro
            }

            throw e;
        }
    }




    public Frasco buscarFrascoPorId(String idFrasco) throws SQLException {
        String sql = "SELECT id_frasco, volume_frasco, lote_id_lote FROM frasco WHERE id_frasco = ?";
        Frasco frasco = null;

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, idFrasco);
            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {
                if (resultadoBusca.next()) {
                    frasco = new Frasco(
                    resultadoBusca.getString("id_frasco"),
                    resultadoBusca.getFloat("volume_frasco"),
                    resultadoBusca.getString("lote_id_lote")
                    );

                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return frasco;
    }




    public List<Frasco> buscarTodos() throws SQLException {
        String sql = "SELECT Id_frasco, volume_frasco, lote_id_lote FROM frasco";

        List<Frasco> frascos = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {
                while (resultadoBusca.next()) {
                    Frasco frasco = new Frasco(
                    resultadoBusca.getString("id_frasco"),
                    resultadoBusca.getFloat("volume_frasco"),
                    resultadoBusca.getString("lote_id_lote")
                    );
                    frascos.add(frasco);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return frascos;
        
    }




    public void atualizarFrasco(Frasco frasco) throws SQLException {

        Connection connection = null;

        try {

            connection = DataBaseUtil.getConnection();

            atualizarFrasco(frasco, connection);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public void atualizarFrasco(Frasco frasco, Connection connection) throws SQLException {
        String sql = "UPDATE frasco SET volume_frasco = ? WHERE id_frasco = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFloat(1, frasco.getVolumeFrasco());
            preparedStatement.setString(2, frasco.getIdFrasco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    


    public List<Frasco> buscarPorIdVacina(int idVacina) throws SQLException {

        String sql = "SELECT f.id_frasco, f.lote_id_lote, f.volume_frasco FROM frasco f " +
                    "INNER JOIN lote l ON f.lote_id_lote = l.id_lote " +
                    "WHERE l.vacina_id_vacina = ?";
        




        List<Frasco> frascos = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idVacina);

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                while (resultadoBusca.next()) {
                    Frasco frasco = new Frasco(
                        resultadoBusca.getString("id_frasco"),
                        resultadoBusca.getFloat("volume_frasco"),
                        resultadoBusca.getString("lote_id_lote")
                    );
                    frascos.add(frasco);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return frascos;
    }
    
}