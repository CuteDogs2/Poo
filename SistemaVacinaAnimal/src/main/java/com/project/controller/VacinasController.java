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

import java.sql.SQLException;
import java.util.List;

public class VacinasController {

    @FXML
    private TextField searchField; // Injetado de barraPesquisa.fxml

    @FXML
    private TableView<Vacina> tabela_dados; // Injetado de tabela.fxml

    private final VacinaService vacinaService = new VacinaService();

    private final ObservableList<Vacina> vacinasList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // 1. Configura as colunas da tabela dinamicamente
        TableColumn<Vacina, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nomeVacina"));

        TableColumn<Vacina, String> colunaFabricante = new TableColumn<>("Fabricante");
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));

        TableColumn<Vacina, Integer> colunaValidade = new TableColumn<>("Validade (meses)");
        colunaValidade.setCellValueFactory(new PropertyValueFactory<>("validadeDaAplicacao"));

        TableColumn<Vacina, Float> colunaDosagem = new TableColumn<>("Dosagem (ml/kg)");
        colunaDosagem.setCellValueFactory(new PropertyValueFactory<>("dosagemPorKg"));

        // Limpa colunas pré-existentes e adiciona as novas
        tabela_dados.getColumns().setAll(colunaNome, colunaFabricante, colunaValidade, colunaDosagem);
        
        // 2. Carrega os dados do banco
        try {
            List<Vacina> vacinas = vacinaService.getVacinasDisponiveis();
            vacinasList.setAll(vacinas);
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: Exibir um alerta para o usuário sobre o erro de banco de dados
        }
        
        // 3. Envolve a lista em uma FilteredList para a funcionalidade de busca
        FilteredList<Vacina> filteredData = new FilteredList<>(vacinasList, b -> true);

        // 4. Adiciona um listener ao campo de busca para filtrar os dados
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(vacina -> {
                // Se o campo de busca estiver vazio, exibe todas as vacinas.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                // Filtra pelo nome ou fabricante da vacina.
                if (vacina.getNomeVacina().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } else if (vacina.getFabricante().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; // Não corresponde ao filtro.
            });
        });

        // 5. Define a lista filtrada como o conteúdo da tabela.
        tabela_dados.setItems(filteredData);
    }
}