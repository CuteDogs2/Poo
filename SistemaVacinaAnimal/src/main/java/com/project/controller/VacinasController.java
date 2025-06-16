package com.project.controller;

import com.project.model.vacina.Vacina;
import com.project.service.VacinaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.List;

public class VacinasController {

    @FXML
    private HBox barraPesquisaNode;

    private TextField searchField;

    @FXML
    private TableView<Vacina> tabela_dados;

    private final VacinaService vacinaService = new VacinaService();

    private final ObservableList<Vacina> vacinasList = FXCollections.observableArrayList();

    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        if (barraPesquisaNode != null) {
            searchField = (TextField) barraPesquisaNode.lookup("#searchField");
        }

        if (searchField == null) {
            throw new IllegalStateException("searchField não pôde ser encontrado dentro de barraPesquisaNode. Verifique o fx:id em barraPesquisa.fxml.");
        }
        TableColumn<Vacina, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nomeVacina"));

        TableColumn<Vacina, String> colunaFabricante = new TableColumn<>("Fabricante");
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));

        TableColumn<Vacina, Integer> colunaValidade = new TableColumn<>("Validade (meses)");
        colunaValidade.setCellValueFactory(new PropertyValueFactory<>("validadeDaAplicacao"));

        TableColumn<Vacina, Float> colunaDosagem = new TableColumn<>("Dosagem (ml/kg)");
        colunaDosagem.setCellValueFactory(new PropertyValueFactory<>("dosagemPorKg"));

        tabela_dados.getColumns().setAll(colunaNome, colunaFabricante, colunaValidade, colunaDosagem);
        
        try {
            List<Vacina> vacinas = vacinaService.getVacinasDisponiveis();
            vacinasList.setAll(vacinas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        FilteredList<Vacina> filteredData = new FilteredList<>(vacinasList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(vacina -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (vacina.getNomeVacina().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (vacina.getFabricante().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        tabela_dados.setItems(filteredData);
    }
}