package com.project.repository;




import com.project.model.vacina.Vacina;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.util.DataBaseUtil;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
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

            try () {

            }

            try () {

            }

            try () {

            }
        }

    }

}
