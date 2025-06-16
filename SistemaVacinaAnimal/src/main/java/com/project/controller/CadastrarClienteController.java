package com.project.controller;


import com.project.util.ValidadorUtil;
import com.project.exception.ValidationException;
import com.project.model.pessoas.Cliente;
import com.project.service.ClienteService;
import com.project.model.Animal;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

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
    private final ValidadorUtil validadorUtil = new ValidadorUtil();



    @FXML
    private void initialize() {

        sexoCliente.getItems().addAll("Masculino", "Feminino");

        sexoAnimal.getItems().addAll("Macho", "Fêmea");

        especieAnimal.getItems().addAll("Canino", "Felino", "Ave");
    }

    @FXML
    private void onRegistrarClienteBtnClicked() {

        
        try {
           
            String nomeDoCliente = nomeCliente.getText();
            String cpfDoCliente = cpfCliente.getText();
            String telefoneDoCliente = telefoneCliente.getText();
            String emailDoCliente = emailCliente.getText();
            LocalDate dataNascimentoDoCliente = dataNascimentoCliente.getValue();

    
            validadorUtil.validarCpf(cpfDoCliente);
            validadorUtil.validarEmail(emailDoCliente);

            char sexoDoCliente = (sexoCliente.getValue() != null && sexoCliente.getValue().equals("Masculino")) ? 'm' : 'f';
            Cliente cliente = new Cliente(nomeDoCliente, cpfDoCliente, telefoneDoCliente, emailDoCliente, dataNascimentoDoCliente, sexoDoCliente);

            Animal animal = new Animal(racaAnimal.getText(), nomeAnimal.getText(), dataNascimentoAnimal.getValue(), 'm', Float.parseFloat(pesoAnimal.getText()), especieAnimal.getValue(), cliente);

            clienteService.cadastrarClienteEAnimal(cliente, animal);

            
            exibirAlerta(AlertType.INFORMATION, "Sucesso", "Cliente e animal cadastrados com sucesso!");

        } catch (ValidationException e) {
            
            exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

        } catch (SQLException e) {
            // Bloco para capturar erros do banco de dados
            exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados. Verifique o console para mais detalhes.");
            e.printStackTrace();
        }
    }

    // Método auxiliar para criar e exibir os alertas
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem texto de cabeçalho
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

}
