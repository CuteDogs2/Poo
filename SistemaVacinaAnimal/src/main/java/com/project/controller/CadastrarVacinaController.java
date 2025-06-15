package com.project.controller;




import java.time.LocalDate;

import com.project.model.vacina.Vacina;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;

import javafx.fxml.FXML;
import javafx.scene.control.*;




public class CadastrarVacinaController {

    @FXML private TextField nomeVacina;
    @FXML private TextField idLoteVacina;
    @FXML private TextField idFrascoVacina;
    @FXML private TextField fabricanteVacina;
    @FXML private DatePicker validadeLoteVacina;
    @FXML private TextField validadeAplicacaoVacina;
    @FXML private TextField dosagemKgMlVacina;
    @FXML private TextField volumeMlVacina;




    @FXML
    private void onCadastrarVacinaClicked() {




        String nome = nomeVacina.getText();
        String fabricante = fabricanteVacina.getText();
        int validadeAplicacao = Integer.parseInt(validadeAplicacaoVacina.getText());
        float dosagemKgMl = Float.parseFloat(dosagemKgMlVacina.getText());




        Vacina vacina = new Vacina(nome, fabricante, validadeAplicacao, dosagemKgMl);



        
        System.out.println("nome: " + vacina.getNomeVacina() + ", " + 
                           "fabricante: " + vacina.getFabricante() + ", " + 
                           "validadAplicacao: " + vacina.getValidadeDaAplicacao() + ", " +
                           "dosagemKgMl: " + vacina.getDosagemPorKg());
        
    }  
}
