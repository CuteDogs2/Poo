package com.project.controller;


import com.project.exception.ValidationException;
import com.project.model.vacina.Lote;
import com.project.model.vacina.Vacina;
import com.project.service.LoteService;
import com.project.service.VacinaService;
import com.project.util.ValidadorUtil;

import java.time.LocalDate;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

import java.sql.SQLException;


/**
 * @author João Falcoão
 */
public class CadastrarLoteController{
    
    @FXML private TextField idLote;
    @FXML private ComboBox<Vacina> idvacina;
    @FXML private DatePicker validadeLoteVacina;

    private final LoteService loteService = new LoteService();
    private final VacinaService vacinaService = new VacinaService();
    private final ValidadorUtil validadorUtil = new ValidadorUtil();
    



    @FXML
    private void initialize() {
        configurarComboBoxVacinas();
        carregarVacinas();
        
    }




    private void configurarComboBoxVacinas() {
        idvacina.setConverter(new StringConverter<Vacina>() {
            @Override
            public String toString(Vacina vacina) {
                return vacina == null ? "" : vacina.getNomeVacina();
            }

            @Override
            public Vacina fromString(String string) {
                return null;
            }
        });




        idvacina.setCellFactory(param -> new ListCell<Vacina>(){
            @Override
            protected void updateItem(Vacina item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNomeVacina() + " (" + item.getFabricante() + ")");
                }
            }
        });
    }




    private void carregarVacinas() {
        
        try {
            List<Vacina> vacinas = vacinaService.getVacinasDisponiveis();

            validadorUtil.validarListaNaoVazia(vacinas, "Nenhuma vacina disponível para cadastro de lote.");

            idvacina.getItems().clear();
            idvacina.getItems().addAll(vacinas);
        } catch (SQLException e) {
            exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados.");
            e.printStackTrace();
        }catch (ValidationException e) {
            exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

        }
    }


    
    
    @FXML
private void onCadastrarLoteClicked() {
    try {
        
        String id_lote_texto = idLote.getText();
        Vacina vacinaSelecionada = idvacina.getValue(); 
        LocalDate validade_lote = validadeLoteVacina.getValue();

       
        ValidadorUtil.validarCampoObrigatorio(id_lote_texto, "ID do Lote");

        
        ValidadorUtil.validarSelecaoObrigatoria(vacinaSelecionada, "Vacina");
        ValidadorUtil.validarSelecaoObrigatoria(validade_lote, "Data de Validade");
        
        
        int id_vacina = vacinaSelecionada.getIdVacina();
        
        Lote lote = new Lote(id_lote_texto, id_vacina, validade_lote);
        
        loteService.cadastraLote(lote);
        
       
        exibirAlerta(AlertType.INFORMATION, "Sucesso", "Lote cadastrado com sucesso!");

        
        idLote.clear();
        idvacina.getSelectionModel().clearSelection();
        validadeLoteVacina.setValue(null);

    } catch (ValidationException e) {
       
        exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

    } catch (SQLException e) {
        
        exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar o lote.");
        e.printStackTrace();
    } catch (Exception e) {
        
        exibirAlerta(AlertType.ERROR, "Erro Inesperado", "Ocorreu um erro inesperado na aplicação.");
        e.printStackTrace();
    }
}


    /**
     * @author Guthierrys
     */
    @FXML
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem texto de cabeçalho
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
    
