package com.project.controller;




import com.project.model.pessoas.Cliente;
import com.project.service.ClienteService;
import com.project.model.Animal;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;




public class CadastrarClienteController {




    @FXML private TextField nomeCliente;
    @FXML private TextField cpfCliente;
    @FXML private TextField telefoneCliente;
    @FXML private TextField emailCliente;
    @FXML private DatePicker dataNascimentoCliente;
    @FXML private ComboBox<String> sexoCliente;




    @FXML private TextField nomeAnimal;
    @FXML private TextField pesoAnimal;
    @FXML private ComboBox<String> especieAnimal;
    @FXML private TextField racaAnimal;
    @FXML private DatePicker dataNascimentoAnimal;
    @FXML private ComboBox<String> sexoAnimal;




    private final ClienteService clienteService = new ClienteService();




    @FXML
    private void initialize() {

        sexoCliente.getItems().addAll("Masculino", "Feminino");

        sexoAnimal.getItems().addAll("Macho", "Fêmea");

        especieAnimal.getItems().addAll("Canino", "Felino", "Ave");
    }

    @FXML
    private void onRegistrarClienteBtnClicked() {



        String nomeDoCliente = nomeCliente.getText();
        String cpfDoCliente = cpfCliente.getText();
        String telefoneDoCliente = telefoneCliente.getText();
        String emailDoCliente = emailCliente.getText();
        LocalDate dataNascimentoDoCliente = dataNascimentoCliente.getValue();
        char sexoDoCliente = (sexoCliente.getValue() != null && sexoCliente.getValue().equals("Masculino")) ? 'm' : 'f';


        
        String racaDoAnimal = racaAnimal.getText();
        String nomeDoAnimal = nomeAnimal.getText();
        LocalDate dataNascimentoDoAnimal = dataNascimentoAnimal.getValue();
        char sexoDoAnimal = (sexoAnimal.getValue() != null && sexoAnimal.getValue().equals("Macho")) ? 'm' : 'f';
        Float pesoDoAnimal = Float.parseFloat(pesoAnimal.getText());
        String especie = especieAnimal.getValue();
        
        
        

        Cliente cliente = new Cliente(nomeDoCliente, cpfDoCliente, telefoneDoCliente, emailDoCliente, dataNascimentoDoCliente, sexoDoCliente);

        Animal animal = new Animal(racaDoAnimal, nomeDoAnimal, dataNascimentoDoAnimal, sexoDoAnimal, pesoDoAnimal, especie, cliente);

        try {

            clienteService.cadastrarClienteEAnimal(cliente, animal);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

        }

        if (animal != null){
            System.out.println("CLIENTE: " + "nome: " + cliente.getNome() + ", " + "cpf: " + cliente.getCpf() + ", " +
                            "telefone: " + cliente.getTelefone() + ", " + "email: " + cliente.getEmail() + ", " +
                            "dataNascimento: " + cliente.getDataNascimento() + ", " + "sexo: " + cliente.getSexo());

            System.out.println("ANIMAL: " + "nome: " + animal.getNome() + ", " + "data de nascimento: " + animal.getDataNascimento() + ", " +
                            "sexo: " + animal.getSexo() + ", " + "peso: " + animal.getPeso() + ", " +
                            "especie: " + animal.getEspecie() + ", " + "cpf do dono: " + animal.getDono().getCpf());
        }
    }
}