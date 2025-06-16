package com.project.controller;

import com.project.model.vacina.Lote;
import com.project.exception.ValidationException;
import com.project.model.vacina.Frasco;
import com.project.service.FrascoService;
import com.project.service.LoteService;
import com.project.util.ValidadorUtil;
import com.project.repository.LoteRepository;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import java.util.List;

public class CadastrarFrascoController {

    @FXML private TextField Idfrasco;
    @FXML private TextField volumeFrasco;
    @FXML private ComboBox<Lote> SelecionarIDLote;

    private final FrascoService frascoService = new FrascoService();
    private final LoteService loteService = new LoteService();
    private final ValidadorUtil validadorUtil = new ValidadorUtil();




    @FXML
    private void initialize() {
        configurarComboBoxLotes();
        carregarLotesDisponiveis();
    }




    @FXML
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem texto de cabeçalho
        alerta.setContentText(mensagem);
        alerta.showAndWait();
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
            exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados. Verifique o console para mais detalhes.");
            e.printStackTrace();
        }
    }

    @FXML
    private void onCadastrarFrascoClicked() {
    try {
        
        String nomeFrasco = Idfrasco.getText();
        String volumeTexto = volumeFrasco.getText();
        Lote loteSelecionado = SelecionarIDLote.getValue();

        
        ValidadorUtil.validarCampoObrigatorio(nomeFrasco, "ID do Frasco");
        ValidadorUtil.validarCampoObrigatorio(volumeTexto, "Volume do Frasco");
        
        if (loteSelecionado == null) {
            
            throw new ValidationException("É obrigatório selecionar um Lote.");
        }

        
        float volume = Float.parseFloat(volumeTexto);
        String idLote = loteSelecionado.getIdLote();

        Frasco frasco = new Frasco(nomeFrasco, volume, idLote);
        frascoService.cadastrarFrasco(frasco);

        exibirAlerta(AlertType.INFORMATION, "Sucesso", "Frasco cadastrado com sucesso!");

        // Limpa os campos após o sucesso
        Idfrasco.clear();
        volumeFrasco.clear();
        SelecionarIDLote.getSelectionModel().clearSelection();

    } catch (ValidationException e) {
       
        exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

    } catch (NumberFormatException e) {
        
        exibirAlerta(AlertType.WARNING, "Erro de Formato", "O campo 'Volume do Frasco' deve conter um número válido (ex: 10.5).");

    } catch (SQLException e) {
        exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados.");
        e.printStackTrace();
    }
}
   
}

