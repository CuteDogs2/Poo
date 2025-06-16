package com.project.controller;




import java.sql.SQLException;
import java.time.LocalDate;

import com.project.model.vacina.Vacina;
import com.project.exception.ValidationException;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.service.VacinaService;
import com.project.util.ValidadorUtil;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;




public class CadastrarVacinaController {

    @FXML private TextField nomeVacina;
    @FXML private TextField idLoteVacina;
    @FXML private TextField idFrascoVacina;
    @FXML private TextField fabricanteVacina;
    @FXML private DatePicker validadeLoteVacina;
    @FXML private TextField validadeAplicacaoVacina;
    @FXML private TextField dosagemKgMlVacina;
    @FXML private TextField volumeMlVacina;

    private final VacinaService vacinaService = new VacinaService();

    private final ValidadorUtil validadorUtil = new ValidadorUtil();


    @FXML
private void onCadastrarVacinaClicked() {
    try {
        // Validação dos campos de texto obrigatórios
        validadorUtil.validarCampoObrigatorio(nomeVacina.getText(), "Nome da vacina");
        validadorUtil.validarCampoObrigatorio(fabricanteVacina.getText(), "Fabricante da vacina");
        validadorUtil.validarCampoObrigatorio(validadeAplicacaoVacina.getText(), "Validade da aplicação");
        validadorUtil.validarCampoObrigatorio(dosagemKgMlVacina.getText(), "Dosagem");

        
        String nome = nomeVacina.getText();
        String fabricante = fabricanteVacina.getText();
        int validadeAplicacao = Integer.parseInt(validadeAplicacaoVacina.getText());
        float dosagemKgMl = Float.parseFloat(dosagemKgMlVacina.getText());

        
        Vacina vacina = new Vacina(nome, fabricante, validadeAplicacao, dosagemKgMl);

        
        vacinaService.cadastrarVacina(vacina);

        
        exibirAlerta(AlertType.INFORMATION, "Sucesso", "Vacina cadastrada com sucesso!");

        
        nomeVacina.clear();
        fabricanteVacina.clear();
        validadeAplicacaoVacina.clear();
        dosagemKgMlVacina.clear();

    } catch (ValidationException e) {
        
        exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

    } catch (NumberFormatException e) {
        
        exibirAlerta(AlertType.WARNING, "Erro de Formato", "Os campos 'Validade' e 'Dosagem' devem conter apenas números.");

    } catch (SQLException e) {
        
        exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados.");
        e.printStackTrace();
    }
}  
    @FXML
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem texto de cabeçalho
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
