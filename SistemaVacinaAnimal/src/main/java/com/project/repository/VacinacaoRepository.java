package com.project.repository;




import com.project.model.pessoas.Cliente;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.model.vacina.Vacina;
import com.project.model.Animal;
import com.project.model.Vacinacao;
import com.project.model.pessoas.Veterinario;
import com.project.util.ClassMount;
import com.project.util.DataBaseUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
//* */



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
            preparedStatement.setString(6, vacinacao.getIdFrascoUtilizado());

            preparedStatement.executeUpdate();


        }
    }




    public List<Vacinacao>  BuscarVacinacaoPorIdAnimal(int id_animal) throws SQLException {
        



        String sql = 
                    "SELECT v.dataAplicacao, v.dataRetorno, v.dose_aplicada, " +
                    "pvet.nome AS veterinario_nome, vet.crmv AS veterinario_crmv, " +
                    "vac.nome AS vacina_nome, vac.fabricante AS vacina_fabricante, vac.validade_da_aplicacao AS vacina_validade_aplicacao, vac.dosagem AS vacina_dosagem, " +
                    "f.id_frasco, f.volume_frasco, " +
                    "l.id_lote, l.data_validade AS lote_data_validade, " +
                    "a.idanimal, a.raca, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, " +
                    "p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo " +
                    "FROM vacinacao v " + "JOIN veterinario vet ON v.veterinario_crmv = vet.crmv" +
                    "JOIN pessoa pvet ON pvet.funcionario_crmv = vet.crmv " +
                    "JOIN frasco f ON v.frasco_id_frasco = f.id_frasco " +
                    "JOIN lote l ON f.lote_id_lote = l.id_lote " +
                    "JOIN vacina vac ON l.vacina_id_vacina = vac.id_vacina " +
                    "JOIN animal a ON v.animal_idanimal = a.idanimal " +
                    "JOIN pessoa p ON a.pessoa_cpf = p.cpf " +
                    "WHERE v.animal_idanimal = ?";
    



        ClassMount classMount = new ClassMount();

        List<Vacinacao> vacinacoes = new ArrayList<>();
        



        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_animal);
            
            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {
            
                while (resultadoBusca.next()) {

  
                    vacinacoes.add(classMount.vacinacaoMounter(resultadoBusca));

                    /*
                    Cliente dono = new Cliente(resultadoBusca.getString("nome_dono"), resultadoBusca.getString("pessoa_cpf"), resultadoBusca.getString("telefone"), resultadoBusca.getString("email"), resultadoBusca.getDate("dono_data_nascimento").toLocalDate(), resultadoBusca.getString("dono_sexo").charAt(0));




                    Animal animal = new Animal(resultadoBusca.getString("raca"), resultadoBusca.getInt("idanimal"), resultadoBusca.getString("animal_nome"), resultadoBusca.getDate("data_nascimento_animal").toLocalDate(), resultadoBusca.getString("animal_sexo").charAt(0), resultadoBusca.getFloat("peso"), resultadoBusca.getString("especie"), dono);



                    
                    Veterinario veterinario = new Veterinario(resultadoBusca.getString("veterinario_crmv"), resultadoBusca.getString("veterinario_nome"));



                    
                    Frasco frasco = new Frasco(resultadoBusca.getString("id_frasco"), resultadoBusca.getFloat("volume_frasco"));



                    
                    Lote lote = new Lote(resultadoBusca.getString("id_lote"), resultadoBusca.getDate("lote_data_validade").toLocalDate());
                    
                    lote.getFrascos().add(frasco);



                    
                    Vacina vacina = new Vacina(resultadoBusca.getString("vacina_nome"), resultadoBusca.getString("vacina_fabricante"), resultadoBusca.getInt("vacina_validade_aplicacao"),resultadoBusca.getFloat("vacina_dosagem"));

                    vacina.getLotes().add(lote);
 



                    Vacinacao vacinacao = new Vacinacao(animal, vacina, veterinario, resultadoBusca.getDate("dataAplicacao").toLocalDate(), 
                        (resultadoBusca.getDate("dataRetorno") != null ? resultadoBusca.getDate("dataRetorno").toLocalDate() : null),
                    resultadoBusca.getFloat("dose_aplicada"), resultadoBusca.getString("id_frasco"));

                    vacinacoes.add(vacinacao);
                    */



                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return vacinacoes;
    }




    public List<Vacinacao> buscarVacinacaoPorData(LocalDate data) throws SQLException {
        
        String sql = "SELECT v.dataAplicacao, v.dataRetorno, v.dose_aplicada, " +
                    "pvet.nome AS veterinario_nome, vet.crmv AS veterinario_crmv, " +
                    "vac.nome AS vacina_nome, vac.fabricante AS vacina_fabricante, vac.validade_da_aplicacao AS vacina_validade_aplicacao, vac.dosagem AS vacina_dosagem, " +
                    "f.id_frasco, f.volume_frasco, " +
                    "l.id_lote, l.data_validade AS lote_data_validade, " +
                    "a.idanimal, a.raca, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, " +
                    "p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo " +
                    "FROM vacinacao v " + "JOIN veterinario vet ON v.veterinario_crmv = vet.crmv" +
                    "JOIN pessoa pvet ON pvet.funcionario_crmv = vet.crmv " +
                    "JOIN frasco f ON v.frasco_id_frasco = f.id_frasco " +
                    "JOIN lote l ON f.lote_id_lote = l.id_lote " +
                    "JOIN vacina vac ON l.vacina_id_vacina = vac.id_vacina " +
                    "JOIN animal a ON v.animal_idanimal = a.idanimal " +
                    "JOIN pessoa p ON a.pessoa_cpf = p.cpf " +
                    "WHERE v.dataAplicacao = ?";

        ClassMount classMount = new ClassMount();

        List<Vacinacao> vacinacoes = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDate(1, Date.valueOf(data));

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                while (resultadoBusca.next()) {

                    vacinacoes.add(classMount.vacinacaoMounter(resultadoBusca));

                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return vacinacoes;
    }




    public List<Vacinacao> buscarVacinacaoPorFrasco(String idFrasco) throws SQLException {

        String sql = "SELECT v.dataAplicacao, v.dataRetorno, v.dose_aplicada, " +
                    "pvet.nome AS veterinario_nome, vet.crmv AS veterinario_crmv, " +
                    "vac.nome AS vacina_nome, vac.fabricante AS vacina_fabricante, vac.validade_da_aplicacao AS vacina_validade_aplicacao, vac.dosagem AS vacina_dosagem, " +
                    "f.id_frasco, f.volume_frasco, " +
                    "l.id_lote, l.data_validade AS lote_data_validade, " +
                    "a.idanimal, a.raca, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, " +
                    "p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo " +
                    "FROM vacinacao v " + "JOIN veterinario vet ON v.veterinario_crmv = vet.crmv" +
                    "JOIN pessoa pvet ON pvet.funcionario_crmv = vet.crmv " +
                    "JOIN frasco f ON v.frasco_id_frasco = f.id_frasco " +
                    "JOIN lote l ON f.lote_id_lote = l.id_lote " +
                    "JOIN vacina vac ON l.vacina_id_vacina = vac.id_vacina " +
                    "JOIN animal a ON v.animal_idanimal = a.idanimal " +
                    "JOIN pessoa p ON a.pessoa_cpf = p.cpf " +
                    "WHERE v.frasco_id_frasco = ?";

                    ClassMount classMount = new ClassMount();

                    List<Vacinacao> vacinacoes = new ArrayList<>();

                    try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                        preparedStatement.setString(1, idFrasco);

                        try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                            while (resultadoBusca.next()) {

                                vacinacoes.add(classMount.vacinacaoMounter(resultadoBusca));

                            }
                        }
                    } catch (SQLException e) {
                        e.getMessage();
                        e.printStackTrace();

                        throw e;
                    }

                    return vacinacoes;
    }




    public void  AtualizarVacina(Vacinacao vacinacao) throws SQLException {
        String sql = "UPDATE vacinacao SET raca = ?, dataAplicacao = ?, dataRetorno = ?, sexo = ?, vacina_Id_frasco = ?,  = ?, pessoa_cpf = ? WHERE idV = ?";

    }
}
