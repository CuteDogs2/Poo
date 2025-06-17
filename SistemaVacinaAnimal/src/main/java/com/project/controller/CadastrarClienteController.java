package com.project.controller;


import com.project.util.ValidadorUtil;
import com.project.exception.ValidationException;
import com.project.model.pessoas.Cliente;
import com.project.service.AnimalService;
import com.project.service.ClienteService;
import com.project.tasks.ClienteTask;
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
    private final AnimalService animalService = new AnimalService();
    private final ValidadorUtil validadorUtil = new ValidadorUtil();
    private ClienteTask clienteTask;




    @FXML
    private void initialize() {

        sexoCliente.getItems().addAll("Masculino", "Feminino");

        sexoAnimal.getItems().addAll("Macho", "Fêmea");

        especieAnimal.getItems().addAll("Canino", "Felino", "Ave");

        clienteTask = new ClienteTask(this);

        cpfCliente.focusedProperty().addListener((observable, oldValue, newValue) -> {
            String cpf = cpfCliente.getText();
            

            if (!cpf.isEmpty()) {
                try {
                    clienteTask.buscarClientePorCpf(cpf);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
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
            validadorUtil.validarCampoObrigatorio(nomeDoCliente, "Nome do Cliente");
            
            char sexoDoCliente = (sexoCliente.getValue() != null && sexoCliente.getValue().equals("Masculino")) ? 'm' : 'f';
            Cliente cliente = new Cliente(nomeDoCliente, cpfDoCliente, telefoneDoCliente, emailDoCliente, dataNascimentoDoCliente, sexoDoCliente);

            Animal animal = new Animal(racaAnimal.getText(), nomeAnimal.getText(), dataNascimentoAnimal.getValue(), 'm', Float.parseFloat(pesoAnimal.getText()), especieAnimal.getValue(), cliente);

            if(cpfCliente.isDisabled()) {
                animalService.cadastrarAnimal(animal);
                limparCampos();
                return;
            }

            clienteService.cadastrarClienteEAnimal(cliente, animal);

            
            exibirAlerta(AlertType.INFORMATION, "Sucesso", "Cliente e animal cadastrados com sucesso!");

            limparCampos();


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




    public void preencherCamposClienteCadastrado(Cliente cliente) {

        nomeCliente.setText(cliente.getNome());
        cpfCliente.setText(cliente.getCpf());
        telefoneCliente.setText(cliente.getTelefone());
        emailCliente.setText(cliente.getEmail());
        dataNascimentoCliente.setValue(cliente.getDataNascimento());
        sexoCliente.setValue(String.valueOf(cliente.getSexo()));




        nomeCliente.setDisable(true);
        cpfCliente.setDisable(true);
        telefoneCliente.setDisable(true);
        emailCliente.setDisable(true);
        dataNascimentoCliente.setDisable(true);
        sexoCliente.setDisable(true);




        nomeCliente.setOpacity(0.5);
        cpfCliente.setOpacity(0.5);
        telefoneCliente.setOpacity(0.5);
        emailCliente.setOpacity(0.5);
        dataNascimentoCliente.setOpacity(0.5);
        sexoCliente.setOpacity(0.5);
    }




    private void limparCampos() {

        nomeCliente.setDisable(false);
        cpfCliente.setDisable(false);
        telefoneCliente.setDisable(false);
        emailCliente.setDisable(false);
        dataNascimentoCliente.setDisable(false);
        sexoCliente.setDisable(false);




        nomeCliente.clear();
        cpfCliente.clear();
        telefoneCliente.clear();
        emailCliente.clear();
        dataNascimentoCliente.setValue(null);
        sexoCliente.setValue(null);



        nomeAnimal.clear();
        pesoAnimal.clear();
        especieAnimal.setValue(null);
        racaAnimal.clear();
        dataNascimentoAnimal.setValue(null);
        sexoAnimal.setValue(null);




        nomeCliente.setOpacity(1);
        cpfCliente.setOpacity(1);
        telefoneCliente.setOpacity(1);
        emailCliente.setOpacity(1);
        dataNascimentoCliente.setOpacity(1);
        sexoCliente.setOpacity(1);
    }

}
