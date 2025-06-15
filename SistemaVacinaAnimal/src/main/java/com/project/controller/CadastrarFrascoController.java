package com.project.controller;

import com.project.model.vacina.Lote;
import com.project.model.vacina.Frasco;
import com.project.service.FrascoService;
import com.project.service.LoteService; 
import com.project.repository.LoteRepository;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import java.util.List;

public class CadastrarFrascoController {

    @FXML private TextField Idfrasco;
    @FXML private TextField volumeFrasco;
    @FXML private ComboBox<Lote> SelecionarIDLote;

    private final FrascoService frascoService = new FrascoService();
    private final LoteService loteService = new LoteService();


    @FXML
    public void initialize() {
        configurarComboBoxLotes();
        carregarLotesDisponiveis();
    }
    
    
    
    private void configurarComboBoxLotes() {
        
        SelecionarIDLote.setConverter(new StringConverter<Lote>() {
            @Override
            public String toString(Lote lote) {

                return lote == null ? "" : lote.getIdLote(); 
            }

            @Override
            public Lote fromString(String string) {
                
                return null;
            }
        });

    
    //metodo para personalização da etqueta, fica vermelho se o lote passar da validade
    SelecionarIDLote.setCellFactory(param -> new ListCell<Lote>() { // SetCellfactory  
        @Override
        protected void updateItem(Lote item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null || item.getIdLote() == null) {
                setText(null);
                setGraphic(null); 
            } else {
                
                setText("ID: " + item.getIdLote() + " - Validade: " + item.getDataValidade().toString());

                
                if (item.getDataValidade().isBefore(LocalDate.now())) {
                    setTextFill(Color.RED);
                } else {
                    setTextFill(Color.BLACK); 
                }
            }
        }
    });
        
    }

    private void carregarLotesDisponiveis() {
        try {
            
            List<Lote> lotes = loteService.buscarLotesDisponiveis();
            SelecionarIDLote.getItems().clear();
            SelecionarIDLote.getItems().addAll(lotes);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void onCadastrarFrascoClicked() {
        
        if (Idfrasco.getText().isEmpty() || volumeFrasco.getText().isEmpty() || SelecionarIDLote.getValue() == null) {

            return;
        }

        try {
            String nomeFrasco = Idfrasco.getText();
            float volume = Float.parseFloat(volumeFrasco.getText());
            
           
            Lote loteSelecionado = SelecionarIDLote.getValue();
            String idLote = loteSelecionado.getIdLote(); 

            Frasco frasco = new Frasco(nomeFrasco, volume, idLote);

            frascoService.cadastrarFrasco(frasco);

            System.out.println("FRASCO CADASTRADO: " + "Id: " + frasco.getIdFrasco() + ", " + "Volume: " + frasco.getVolumeFrasco() + ", " +
                    "Id do lote: " + frasco.getIdLote());

            Idfrasco.clear();
            volumeFrasco.clear();
            SelecionarIDLote.getSelectionModel().clearSelection();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Erro: O volume deve ser um número válido.");
            
        }
    }
}

