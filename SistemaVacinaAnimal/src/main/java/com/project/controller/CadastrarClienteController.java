package com.project.controller;




import com.project.model.pessoas.Cliente;
import com.project.model.animais.Animal;
import com.project.model.animais.Canino;
import com.project.model.animais.Felino;
import com.project.model.animais.Ave;
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




    @FXML private TextField nomeAnimal;
    @FXML private TextField pesoAnimal;
    @FXML private ComboBox<String> especieAnimal;
    @FXML private TextField racaAnimal;
    @FXML private DatePicker dataNascimentoAnimal;
    @FXML private ComboBox<String> sexoAnimal;




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




        String nomeDoAnimal = nomeAnimal.getText();
        Float pesoDoAnimal = Float.parseFloat(pesoAnimal.getText());
        String especieDoAnimal = especieAnimal.getValue();
        String racaDoAnimal = racaAnimal.getText();
        LocalDate dataNascimentoDoAnimal = dataNascimentoAnimal.getValue();
        char sexoDoAnimal = (sexoAnimal.getValue() != null && sexoAnimal.getValue().equals("Macho")) ? 'm' : 'f';
        



        Cliente cliente = new Cliente(nomeDoCliente, cpfDoCliente, telefoneDoCliente, emailDoCliente, dataNascimentoDoCliente, sexoDoCliente);

        Animal animal = null;

        if (especieDoAnimal.equals("Canino")){

            animal = new Canino(racaDoAnimal, nomeDoAnimal, dataNascimentoDoAnimal, sexoDoAnimal, pesoDoAnimal, especieDoAnimal, cliente);
        }

        if (especieDoAnimal.equals("Felino")){
            animal = new Felino(racaDoAnimal, nomeDoAnimal, dataNascimentoDoAnimal, sexoDoAnimal, pesoDoAnimal, especieDoAnimal, cliente);
        }

        if (especieDoAnimal.equals("Ave")){
            animal = new Ave(racaDoAnimal, nomeDoAnimal, dataNascimentoDoAnimal, sexoDoAnimal, pesoDoAnimal, especieDoAnimal, cliente);
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