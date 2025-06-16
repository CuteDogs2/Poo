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
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class ClientesController {

    @FXML
    private TextField searchField; // Injetado de barraPesquisa.fxml

    @FXML
    private TableView<Cliente> tabela_dados; // Injetado de tabela.fxml

    private final ClienteService clienteService = new ClienteService();

    private final ObservableList<Cliente> clientesList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // 1. Configura as colunas da tabela dinamicamente
        TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Cliente, String> colunaCPF = new TableColumn<>("CPF");
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        TableColumn<Cliente, String> colunaTelefone = new TableColumn<>("Telefone");
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Limpa colunas pré-existentes e adiciona as novas

        
        tabela_dados.getColumns().setAll(colunaNome, colunaCPF, colunaTelefone, colunaEmail);

        // 2. Carrega os dados do banco
        try {
            List<Cliente> clientes = clienteService.buscarTodos();
            clientesList.setAll(clientes);
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: Exibir um alerta para o usuário sobre o erro de banco de dados
        }

        // 3. Envolve a lista em uma FilteredList para a funcionalidade de busca
        FilteredList<Cliente> filteredData = new FilteredList<>(clientesList, b -> true);

        // 4. Adiciona um listener ao campo de busca para filtrar os dados
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cliente -> {
                // Se o campo de busca estiver vazio, exibe todos os clientes.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                // Filtra pelo nome ou CPF do cliente.
                if (cliente.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (cliente.getCpf().contains(lowerCaseFilter)) {
                    return true;
                }
                return false; // Não corresponde ao filtro.
            });
        });

        // 5. Define a lista filtrada como o conteúdo da tabela.
        tabela_dados.setItems(filteredData);
    }
}