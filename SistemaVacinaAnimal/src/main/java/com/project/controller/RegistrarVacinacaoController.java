



package com.project.controller;

import com.project.model.Animal;
import com.project.model.vacina.Vacina;
import com.project.service.AnimalService;
import com.project.service.VacinaService;
import com.project.service.VacinacaoService;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;




public class RegistrarVacinacaoController {


    

    @FXML private TextField cpfCliente;
    @FXML private ComboBox<Vacina> vacinaAplicada;
    @FXML private DatePicker dataAplicacao;
    @FXML private DatePicker dataRetorno;
    @FXML private ComboBox<Animal> animalVacinado;
    @FXML private ComboBox<String> identificacaoVeterinario;




    private final AnimalService animalService = new AnimalService();
    
    private final VacinacaoService vacinacaoService = new VacinacaoService();

    private final VacinaService vacinaService = new VacinaService();


    
    @FXML
    public void initialize() throws SQLException {


        

        animalVacinado.setConverter(new StringConverter<Animal>() {




            @Override
            public String toString(Animal animal) {

                return animal == null ? "" : animal.getNome();
            }

            @Override
            public Animal fromString(String string) {
                return null;
            }
        });




        animalVacinado.setCellFactory(param -> new ListCell<Animal>() {
            @Override
            protected void updateItem(Animal item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getNome() == null) {
                    setText(null);
                } else {
                    setText(item.getNome() + " (" + item.getEspecie() + ")");
                }
            }
        });




        configurarComboBoxVacinas();
        carregarVacinas();
    }




    @FXML
    private void carregarAnimais() {
        String cpf = cpfCliente.getText();
        if (cpf == null || cpf.trim().isEmpty()) {
            return;
        }

        try {
            List<Animal> animais = animalService.buscarAnimalPorCpfDono(cpf);

            animalVacinado.getItems().clear();
            animalVacinado.getItems().addAll(animais);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

        }
    }




    @FXML
    private void onRegistrarVacinacaoClicked() {

        Animal animalSelecionado = animalVacinado.getValue();

        Vacina vacinaSelecionada = vacinaAplicada.getValue();

        LocalDate dateDeAplicacao = dataAplicacao.getValue();
        //LocalDate dateDeRetorno = dataRetorno.getValue();

    }
    



    private void configurarComboBoxVacinas() {
        vacinaAplicada.setConverter(new StringConverter<Vacina>() {
            @Override
            public String toString(Vacina vacina) {
                return vacina == null ? "" : vacina.getNomeVacina();
            }

            @Override
            public Vacina fromString(String string) {
                return null; // Não é necessário para uma ComboBox não editável.
            }
        });

        // Opcional: Melhora a exibição na lista suspensa
        vacinaAplicada.setCellFactory(param -> new ListCell<Vacina>() {
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




    private void carregarVacinas() throws SQLException {




        try {

            List<Vacina> vacinas = vacinaService.getVacinasDisponiveis();

            animalVacinado.getItems().clear();
            vacinaAplicada.getItems().setAll(vacinas);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();


        }
    }
}