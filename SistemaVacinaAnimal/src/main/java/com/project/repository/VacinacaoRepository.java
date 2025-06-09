package com.project.repository;




import com.project.model.Vacinacao;
import com.project.util.DataBaseUtil;

import java.sql.*;




public class VacinacaoRepository {
    



    public void inserirVacinacao(Vacinacao vacinacao) throws SQLException {




        String sql = "INSERT INTO vacinacao (dataAplicacao, dataRetorno, veterinario_crmv, dose_aplicada, animal_idanimal, frasco_id_frasco) VALUES (?, ?, ?, ?, ?, ?)";




        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(vacinacao.getDataAplicacao()));

            if (vacinacao.getDataRetorno() != null) {
                preparedStatement.setDate(2, Date.valueOf(vacinacao.getDataRetorno()));
            } else {
                preparedStatement.setNull(2, Types.DATE);
            }

            preparedStatement.setString(3, vacinacao.getVeterinario().getCrmv());
            preparedStatement.setFloat(4, vacinacao.getDoseAplicada());
            preparedStatement.setInt(5, vacinacao.getAnimal().getIdAnimal());

            

        }
    }
}
