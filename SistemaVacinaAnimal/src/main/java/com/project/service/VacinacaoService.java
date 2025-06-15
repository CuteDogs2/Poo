package com.project.service;


import com.project.model.Animal;
import com.project.model.Vacinacao;
import com.project.model.pessoas.Cliente;
import com.project.model.vacina.Vacina;
import com.project.repository.VacinaRepository;
import com.project.repository.VacinacaoRepository;
import com.project.repository.AnimalRepository;
import com.project.repository.ClienteRepository;
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


    public VacinacaoService(VacinaRepository vacinaRepository, ClienteRepository clienteRepository, AnimalRepository animalRepository){
        this.vacinaRepository = vacinaRepository;
        this.clienteRepository = clienteRepository;
        this.animalRepository = animalRepository;
        this.vacinacaoRepository = vacinacaoRepository;
    }

    public VacinacaoService(){
        this.vacinaRepository = new VacinaRepository();
        this.animalRepository = new AnimalRepository();
        this.clienteRepository = new ClienteRepository();
        this.vacinacaoRepository = new VacinacaoRepository();
    }




    public void cadastrarVacinacao(Vacinacao vacinacao) throws SQLException {

        try {
            vacinacaoRepository.inserirVacinacao(vacinacao);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
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