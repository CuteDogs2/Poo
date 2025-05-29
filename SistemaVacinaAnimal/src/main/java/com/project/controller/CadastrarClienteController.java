package com.project.controller;




import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class CadastrarClienteController {

    @FXML private TextField nomeCliente;
    @FXML private TextField cpfCliente;
    @FXML private TextField telefoneCliente;
    @FXML private TextField emailCliente;
    @FXML private DatePicker dataNascimentoCliente;
    @FXML private ComboBox<String> sexoCliente;

    @FXML
    private void initialize() {

        sexoCliente.getItems().addAll("Masculino", "Feminino");
    }

    @FXML
    private void onRegistrarClienteBtnClicked() {

        String nome = nomeCliente.getText();
        String cpf = cpfCliente.getText();
        String telefone = telefoneCliente.getText();
        String email = emailCliente.getText();
        LocalDate dataNascimento = dataNascimentoCliente.getValue();
        String sexoSelecionado = sexoCliente.getValue();
        char sexo = (sexoSelecionado != null && sexoSelecionado.equals("Masculino")) ? 'm' : 'f';

        System.out.println("nome: " + nome + ", " + "cpf: " + cpf + ", " +
                           "telefone: " + telefone + ", " + "email: " + email + ", " +
                           "dataNascimento: " + dataNascimento + ", " + "sexo: " + sexo);

    }
    
}
