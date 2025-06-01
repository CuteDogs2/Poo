package com.project.controller;




import com.project.model.Vacina;
import com.project.model.animais.Animal;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class RegistrarVacinacaoController {

    @FXML private TextField cpfCliente;
    @FXML private ComboBox<Vacina> vacinaAplicada;
    @FXML private DatePicker dataAplicacao;
    @FXML private DatePicker dataRetorno;
    @FXML private ComboBox<Animal> animalVacinado;
    @FXML private ComboBox<String> identificacaoVeterinario;




    public void initialize() {

        //list<Vacina> vacinas = buscar todas as vacinass do banco de dados.
        //

    }




    @FXML
    private void onRegistrarVacinacaoClicked() {

        String cpf = cpfCliente.getText();
        //int vacina = vacinaAplicada.getValue();
        LocalDate dateDeAplicacao = dataAplicacao.getValue();
        LocalDate dateDeRetorno = dataRetorno.getValue();
        

    }
    
}
