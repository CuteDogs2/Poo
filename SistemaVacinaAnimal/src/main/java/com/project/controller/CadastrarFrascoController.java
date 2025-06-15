package com.project.controller;

import com.project.model.vacina.Lote;
import com.project.model.vacina.Frasco;
import com.project.service.FrascoService;
import com.project.service.LoteService; 

import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

        
        SelecionarIDLote.setCellFactory(param -> new ListCell<Lote>() {
            @Override
            protected void updateItem(Lote item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    // Você pode adicionar mais detalhes aqui, se quiser
                    setText("Lote ID: " + item.getIdLote());
                }
            }
        });
    }

    /**
     * Carrega os lotes disponíveis do banco de dados e os adiciona ao ComboBox.
     */
    private void carregarLotesDisponiveis() {
        try {
            // Supondo que você tenha um método em LoteService para buscar todos os lotes
            List<Lote> lotes = loteService.buscarLotesDisponiveis(); 
            SelecionarIDLote.getItems().clear();
            SelecionarIDLote.getItems().addAll(lotes);
        } catch (SQLException e) {
            // Trate a exceção de forma adequada (ex: mostrando um alerta)
            e.printStackTrace();
        }
    }

    @FXML
    private void onCadastrarFrascoClicked() {
        // Validação básica de entrada
        if (Idfrasco.getText().isEmpty() || volumeFrasco.getText().isEmpty() || SelecionarIDLote.getValue() == null) {
            System.err.println("Erro: Todos os campos são obrigatórios.");
            // O ideal aqui é mostrar um Alert para o usuário.
            return;
        }

        try {
            String nomeFrasco = Idfrasco.getText();
            float volume = Float.parseFloat(volumeFrasco.getText());
            
            // CORRIGIDO: Obter o objeto Lote selecionado e, em seguida, seu ID.
            Lote loteSelecionado = SelecionarIDLote.getValue();
            String idLote = loteSelecionado.getIdLote(); // Assumindo que Lote tem getIdLote()

            Frasco frasco = new Frasco(nomeFrasco, volume, idLote);

            frascoService.cadastrarFrasco(frasco);

            System.out.println("FRASCO CADASTRADO: " + "Id: " + frasco.getIdFrasco() + ", " + "Volume: " + frasco.getVolumeFrasco() + ", " +
                    "Id do lote: " + frasco.getIdLote());

            // Limpar campos após o sucesso
            Idfrasco.clear();
            volumeFrasco.clear();
            SelecionarIDLote.getSelectionModel().clearSelection();

        } catch (SQLException e) {
            e.printStackTrace();
            // Mostrar alerta de erro no banco de dados
        } catch (NumberFormatException e) {
            System.err.println("Erro: O volume deve ser um número válido.");
            // Mostrar alerta de erro de formato
        }
    }
}

