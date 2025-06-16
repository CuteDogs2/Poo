package com.project.controller;


import com.project.model.vacina.Lote;
import com.project.service.LoteService;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class CadastrarLoteController{
    
    @FXML private TextField idLote;
    @FXML private TextField idvacina;
    @FXML private DatePicker validadeLoteVacina;

    private final LoteService loteService = new LoteService();


    /**
     *
     */
    @FXML 
    private void onCadastrarLoteClicked(){

        String id_lote = idLote.getText();
        int id_vacina = Integer.parseInt(idvacina.getText());
        LocalDate validade_lote = validadeLoteVacina.getValue();


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
    
