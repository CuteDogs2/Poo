package com.project.repository;




import com.project.model.vacina.Vacina;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.util.DataBaseUtil;

//import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;




public class VacinaRepository {
    



    public void inserirVacina(Vacina vacina) throws SQLException {

        String sqlVacina = "INSERT INTO vacina (nome, fabricante, validade_da_aplicacao, dosagem) VALUES (?, ?, ?, ?)";
        String sqlLote = "INSERT INTO lote (id_lote, vacina_id_vacina, data_validade) VALUES (?, ?, ?)";
        String sqlFrasco = "INSERT INTO frasco (id_frasco, lote_id_lote, volume_frasco) VALUES (?, ?, ?)";

        Connection connection = null;
        try {

            connection = DataBaseUtil.getConnection();
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlVacina, Statement.RETURN_GENERATED_KEYS)) {
                
                preparedStatement.setString(1, vacina.getNomeVacina());
                preparedStatement.setString(2, vacina.getFabricante());
                preparedStatement.setInt(3, vacina.getValidadeDaAplicacao());
                preparedStatement.setFloat(4, vacina.getDosagemPorKg());
                
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    vacina.setIdVacina(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao registrar vacina.");
                }

            }

            for (Lote lote : vacina.getLotes()) {
                
                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlLote)) {

                    preparedStatement.setString(1, lote.getIdLote());
                    preparedStatement.setInt(2, vacina.getIdVacina());
                    preparedStatement.setDate(3, Date.valueOf(lote.getDataValidade()));

                    preparedStatement.executeUpdate();
                }

                for (Frasco frasco : lote.getFrascos()) {

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlFrasco)) {

                        preparedStatement.setString(1, frasco.getIdFrasco());
                        preparedStatement.setString(2, lote.getIdLote());
                        preparedStatement.setFloat(3, frasco.getVolumeFrasco());

                        preparedStatement.executeUpdate();

                    }
                }
            }
            connection.commit(); //confirmar.

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.getMessage();
                    ex.printStackTrace();
                }
            }
            throw e;
            
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.getMessage();
                    e.printStackTrace();
                }
            }
        }

    }



    public List<Vacina> buscarTodas() {

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




    //Buscar
    //Atualizar
}
