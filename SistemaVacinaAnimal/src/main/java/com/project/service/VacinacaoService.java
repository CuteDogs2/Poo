package com.project.service;


import com.project.model.Animal;
import com.project.model.Vacinacao;
import com.project.model.pessoas.Cliente;
import com.project.model.vacina.Vacina;
import com.project.repository.VacinaRepository;
import com.project.repository.VacinacaoRepository;
import com.project.repository.AnimalRepository;
import com.project.repository.ClienteRepository;
import com.project.repository.FrascoRepository;
import com.project.model.vacina.*;

import java.sql.SQLException;
import java.sql.Connection;
import com.project.util.DataBaseUtil;

import java.util.List;
import java.util.ArrayList;




public class VacinacaoService{


//atributos

    private VacinaRepository vacinaRepository;
    private ClienteRepository clienteRepository;
    private AnimalRepository animalRepository;
    private VacinacaoRepository vacinacaoRepository;
    private FrascoRepository frascoRepository;


    public VacinacaoService(VacinaRepository vacinaRepository, ClienteRepository clienteRepository, AnimalRepository animalRepository){
        this.vacinaRepository = vacinaRepository;
        this.clienteRepository = clienteRepository;
        this.animalRepository = animalRepository;
        this.vacinacaoRepository = vacinacaoRepository;
        this.frascoRepository = new FrascoRepository();
    }

    public VacinacaoService(){
        this.vacinaRepository = new VacinaRepository();
        this.animalRepository = new AnimalRepository();
        this.clienteRepository = new ClienteRepository();
        this.vacinacaoRepository = new VacinacaoRepository();
        this.frascoRepository = new FrascoRepository();
    }




    public void registrarVacinacao(Vacinacao vacinacao) throws SQLException {

        Connection connection = null;

        try {
            connection = DataBaseUtil.getConnection();
            connection.setAutoCommit(false);

            Animal animal = vacinacao.getAnimal();
            Vacina vacina = vacinacao.getVacina();
            Frasco frasco = frascoRepository.buscarFrascoPorId(vacinacao.getIdFrascoUtilizado());

            if (frasco == null) {
                throw new SQLException("Frasco não encontrado pelo ID: " + vacinacao.getIdFrascoUtilizado());
            }

            float doseAplicada = animal.getPeso() * vacina.getDosagemPorKg();
            vacinacao.setDoseAplicada(doseAplicada);

            if (frasco.getVolumeFrasco() < doseAplicada) {
                throw new SQLException("Volume do frasco insuficiente.");
            }

            frasco.setVolumeFrasco(frasco.getVolumeFrasco() - doseAplicada);

            frascoRepository.atualizarFrasco(frasco, connection);
            vacinacaoRepository.inserirVacinacao(vacinacao, connection);

            connection.commit();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            if (connection != null) {
                connection.rollback();
            }

            throw e;

        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
     
    }

    /*
    public void cadastraVacinacao(Cliente cliente, Animal animal, Vacina vacina) throws SQLException{

        Connection conection = null;

        try{
            conection = DataBaseUtil.getConnection();

            conection.setAutoCommit(false);

            clienteRepository.inserirCliente(cliente, conection);
            animalRepository.inserirAnimal(animal, conection);
            vacinaRepository.inserirVacina(vacina, conection);

            conection.commit();

        }catch(SQLException e){
            if (conection != null) {
                conection.rollback();
            }

            throw e;
        }
        

    }
    */

}