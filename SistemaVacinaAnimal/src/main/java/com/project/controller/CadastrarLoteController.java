package com.project.controller;


import com.project.model.vacina.Lote;
import com.project.model.vacina.Vacina;
import com.project.service.LoteService;
import com.project.service.VacinaService;

import java.time.LocalDate;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

import java.sql.SQLException;

public class CadastrarLoteController{
    
    @FXML private TextField idLote;
    @FXML private ComboBox<Vacina> idvacina;
    @FXML private DatePicker validadeLoteVacina;

    private final LoteService loteService = new LoteService();
    private final VacinaService vacinaService = new VacinaService();




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
            idvacina.getItems().clear();
            idvacina.getItems().addAll(vacinas);
        } catch (SQLException e) {
            //exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao carregar as vacinas.");
            e.printStackTrace();
        }
    }


    
    
    @FXML 
    private void onCadastrarLoteClicked(){

        String id_lote = idLote.getText();
        Vacina vacinaSelecionada = idvacina.getValue();
        LocalDate validade_lote = validadeLoteVacina.getValue();


        int id_vacina = vacinaSelecionada.getIdVacina();
        Lote lote = new Lote(id_lote, id_vacina, validade_lote);


        try {

            loteService.cadastraLote(lote);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

        }

        if (lote != null){
            System.out.println("LOTE: " + "id do lote: " + lote.getIdLote() + ", " + "id da vacina: " + lote.getIdVacina() + ", " +
                            "Validade do lote: " + lote.getDataValidade());
        }
    }
}
    
