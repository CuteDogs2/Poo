package com.project.repository;


import com.project.model.vacina.Frasco;
import com.project.util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FrascoRepository {
    
    public void inserirFrasco(Frasco frasco) throws SQLException {
        //String sql = "INSERT INTO frasco (id_frasco, volume_frasco) VALUES (?, ?)";
        
        Connection connection = DataBaseUtil.getConnection();

        inserirFrasco(frasco, connection);
        
    }
    


    
    public void inserirFrasco(Frasco frasco, Connection connection) throws SQLException {
        String sql = "INSERT INTO frasco (id_frasco, volume_frasco) VALUES (?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, frasco.getIdFrasco());
            preparedStatement.setFloat(2, frasco.getVolumeFrasco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public Frasco buscarFrascoPorId(String idFrasco) throws SQLException {
        String sql = "SELECT * FROM frasco WHERE id_frasco = ?";
        Frasco frasco = null;

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, idFrasco);
            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {
                if (resultadoBusca.next()) {
                    frasco = new Frasco(
                    resultadoBusca.getString("id_frasco"),
                    resultadoBusca.getFloat("volume_frasco")
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
        String sql = "SELECT Id_frasco, volume_frasco FROM frasco";

        List<Frasco> frascos = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {
                while (resultadoBusca.next()) {
                    Frasco frasco = new Frasco(
                    resultadoBusca.getString("id_frasco"),
                    resultadoBusca.getFloat("volume_frasco")
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
        String sql = "UPDATE frasco SET volume_frasco = ? WHERE id_frasco = ?";

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setFloat(1, frasco.getVolumeFrasco());
            preparedStatement.setString(2, frasco.getIdFrasco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }
    
}