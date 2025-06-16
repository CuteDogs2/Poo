package com.project.controller;

import com.project.model.pessoas.Cliente;
import com.project.service.ClienteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.List;

public class ClientesController {

    @FXML
    private HBox barraPesquisaNode;

    private TextField searchField;

    @FXML
    private TableView<Cliente> tabela_dados;

    private final ClienteService clienteService = new ClienteService();

    private final ObservableList<Cliente> clientesList = FXCollections.observableArrayList();

    @SuppressWarnings("unchecked")
    @FXML
    public void initialize() {
        if (barraPesquisaNode != null) {
            searchField = (TextField) barraPesquisaNode.lookup("#searchField");
        }

        if (searchField == null) {
            throw new IllegalStateException("searchField não pôde ser encontrado dentro de barraPesquisaNode. Verifique o fx:id em barraPesquisa.fxml.");
        }

        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Cliente, String> colunaCPF = new TableColumn<>("CPF");
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));


        
        tabela_dados.getColumns().setAll(colunaNome, colunaCPF, colunaTelefone, colunaEmail);

        try {
            List<Cliente> clientes = clienteService.buscarTodos();
            clientesList.setAll(clientes);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FilteredList<Cliente> filteredData = new FilteredList<>(clientesList, b -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cliente -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (cliente.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (cliente.getCpf().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        tabela_dados.setItems(filteredData);
    }
}