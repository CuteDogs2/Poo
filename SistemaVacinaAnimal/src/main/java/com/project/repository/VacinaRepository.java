package com.project.repository;




import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.model.vacina.Vacina;
import com.project.util.DataBaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class VacinaRepository {
    



    public void inserirVacina(Vacina vacina) throws SQLException {

        String sql = "INSERT INTO vacina (nome, fabricante, validade_da_aplicacao, dosagem) VALUES (?, ?, ?, ?)";

        Connection connection = DataBaseUtil.getConnection();

        inserirVacina(vacina,connection);
        /*try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            
            preparedStatement.setString(1, vacina.getNomeVacina());
            preparedStatement.setString(2, vacina.getFabricante());
            preparedStatement.setInt(3, vacina.getValidadeDaAplicacao());
            preparedStatement.setFloat(4, vacina.getDosagemPorKg());
            
            preparedStatement.executeUpdate();

            

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) { 

                if (generatedKeys.next()) {
                    vacina.setIdVacina(generatedKeys.getInt(1));
                }
            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();

                throw e;
            }
        }
        */
    }

    public void inserirVacina(Vacina vacina, Connection connection) throws SQLException {

        String sql = "INSERT INTO vacina (nome, fabricante, validade_da_aplicacao, dosagem) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            
            preparedStatement.setString(1, vacina.getNomeVacina());
            preparedStatement.setString(2, vacina.getFabricante());
            preparedStatement.setInt(3, vacina.getValidadeDaAplicacao());
            preparedStatement.setFloat(4, vacina.getDosagemPorKg());
            
            preparedStatement.executeUpdate();

            

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) { 

                if (generatedKeys.next()) {
                    vacina.setIdVacina(generatedKeys.getInt(1));
                }
            } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();

                throw e;
            }
        }
    }


    //String sql = "SELECT nome, id_vacina, fabricante, validade_da_aplicacao, dosagem FROM vacina";

    public List<Vacina> buscarTodasVacinas() throws SQLException {

        String sql = "SELECT nome, id_vacina, fabricante, validade_da_aplicacao, dosagem FROM vacina";

        List<Vacina> vacinas = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultadoBusca = preparedStatement.executeQuery()) {
            
            while (resultadoBusca.next()) {
                Vacina vacina = new Vacina(resultadoBusca.getString("nome"), resultadoBusca.getInt("id_vacina"), resultadoBusca.getString("fabricante"), resultadoBusca.getInt("validade_da_aplicacao"), resultadoBusca.getFloat("dosagem"));

                vacinas.add(vacina);
            }
        }
        return vacinas;
    }




    /*
    public List<Vacina> buscarTodasVacinas() throws SQLException {

        Map<Integer, Vacina> vacinaMap = new HashMap<>();
        Map<String, Lote> loteMap = new HashMap<>();

        String sql = "SELECT v.id_vacina, v.nome, v.fabricante, v.validade_da_aplicacao, v.dosagem, " + "l.id_lote, l.data_validade, " + "f.id_frasco, volume_frasco " + "FROM vacina v " + "LEFT JOIN lote l ON v.idVacina = l.vacina_id_vacina " + "LEFT JOIN frasco f ON l.id_lote = f.lote_id_lote " + "ORDER BY v.id_vacina, l.id_lote, f.id_frasco";

        try (Connection connection = DataBaseUtil.getConnection(); Statement preparedStatement = connection.createStatement(); ResultSet resultSet = preparedStatement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idVacina = resultSet.getInt("id_vacina");
                Vacina vacina = vacinaMap.computeIfAbsent(idVacina, key -> {
                    try {
                        return new Vacina(
                            resultSet.getString("nome"),
                            resultSet.getInt("id_vacina"),
                            resultSet.getString("fabricante"),
                            resultSet.getInt("validade_da_aplicacao"),
                            resultSet.getFloat("dosagem")
                        );
                    } catch (SQLException e) { throw new RuntimeException(e); }
                });

                String idLote = resultSet.getString("id_lote");
                
                if (idLote != null) {
                    Lote lote = loteMap.computeIfAbsent(idLote, key -> {
                        try {

                            Lote novoLote = new Lote(idLote, resultSet.getDate("data_validade").toLocalDate());

                            vacina.getLotes().add(novoLote);

                            return novoLote;

                        } catch (SQLException e) { throw new RuntimeException(e); }
                    });

                    String idFrasco = resultSet.getString("id_frasco");

                    if (idFrasco != null) {
                        Frasco frasco = new Frasco(idFrasco, resultSet.getFloat("volume_frasco"));

                        if (lote.getFrascos().stream().noneMatch(f -> f.getIdFrasco().equals(idFrasco))) {
                            lote.getFrascos().add(frasco);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return new ArrayList<>(vacinaMap.values());
    }
    */



    //Buscar
    //Atualizar
}