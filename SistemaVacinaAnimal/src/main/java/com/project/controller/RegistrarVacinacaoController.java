



package com.project.controller;

import com.project.model.Animal;
import com.project.model.vacina.Vacina;
import com.project.repository.AnimalRepository;
import com.project.repository.VacinaRepository;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.util.List;




public class RegistrarVacinacaoController {


    

    @FXML private TextField cpfCliente;
    @FXML private ComboBox<Vacina> vacinaAplicada;
    @FXML private DatePicker dataAplicacao;
    @FXML private DatePicker dataRetorno;
    @FXML private ComboBox<Animal> animalVacinado;
    @FXML private ComboBox<String> identificacaoVeterinario;




    private final AnimalRepository animalRepository = new AnimalRepository();
    private final VacinaRepository vacinaRepository = new VacinaRepository();



    
    @FXML
    public void initialize() {




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
    private void buscarAnimaisPorCpf() {
        String cpf = cpfCliente.getText();
        if (cpf == null || cpf.trim().isEmpty()) {
            return;
        }

        try {
            List<Animal> animais = animalRepository.buscarAnimalPorCpfDono(cpf);

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

        //String cpf = cpfCliente.getText();
        //int vacina = vacinaAplicada.getValue();
        //LocalDate dateDeAplicacao = dataAplicacao.getValue();
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




    private void carregarVacinas() {




        try {
            // Usa o método buscarTodasVacinas() que já existe no seu repositório
            List<Vacina> vacinasDisponiveis = vacinaRepository.buscarTodasVacinas();
            vacinaAplicada.getItems().clear();
            vacinaAplicada.getItems().addAll(vacinasDisponiveis);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

        }
    }
}