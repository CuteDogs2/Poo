package com.project.controller;



import com.project.model.Vacina;
import java.time.LocalDate;
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
        String idFrasco = idFrascoVacina.getText();
        String idLote = idLoteVacina.getText();
        String fabricante = fabricanteVacina.getText();
        LocalDate validadeLote = validadeLoteVacina.getValue();
        int validadeAplicacao = Integer.parseInt(validadeAplicacaoVacina.getText());
        float dosagemKgMl = Float.parseFloat(dosagemKgMlVacina.getText());
        float volumeFrasco = Float.parseFloat(volumeMlVacina.getText());

        Vacina vacina = new Vacina(nome, idFrasco, idLote, fabricante, validadeLote, validadeAplicacao, dosagemKgMl, volumeFrasco);

        System.out.println("nome: " + vacina.getNomeVacina() + ", " + 
                           "idLote: " + vacina.getIdLote() + ", " + 
                           "idFrasco: " + vacina.getIdFrascoVacina() + ", " + 
                           "fabricante: " + vacina.getFabricante() + ", " + 
                           "validadeLote: " + vacina.getValidadeDoLote() + ", " + 
                           "validadAplicacao: " + vacina.getValidadeDaAplicacao() + ", " +
                           "dosagemKgMl: " + vacina.getDosagemPorKg() + ", " +
                           "volumeFrasco: " + vacina.getVolumeVacina());

    }

}
