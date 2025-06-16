



package com.project.controller;

import com.project.exception.ValidationException;
import com.project.model.Animal;
import com.project.model.Vacinacao;
import com.project.model.pessoas.Veterinario;
import com.project.model.vacina.Vacina;
import com.project.model.vacina.Frasco;
import com.project.service.AnimalService;
import com.project.service.VacinaService;
import com.project.service.VacinacaoService;
import com.project.service.FrascoService;
import com.project.service.VeterinarioService;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;




public class RegistrarVacinacaoController {


    

    @FXML private TextField cpfCliente;
    @FXML private ComboBox<Vacina> vacinaAplicada;
    @FXML private ComboBox<Frasco> frascoAplicado;
    @FXML private DatePicker dataAplicacao;
    @FXML private DatePicker dataRetorno;
    @FXML private ComboBox<Animal> animalVacinado;
    @FXML private ComboBox<Veterinario> identificacaoVeterinario;




    private final AnimalService animalService = new AnimalService();
    
    private final VacinacaoService vacinacaoService = new VacinacaoService();

    private final VacinaService vacinaService = new VacinaService();

    private final FrascoService frascoService = new FrascoService();

    private final VeterinarioService veterinarioService = new VeterinarioService();


    
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
        configurarComboBoxFrascos();
        configurarComboBoxVeterinarios();

        carregarVacinas();
        carregarVeterinarios();

        vacinaAplicada.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if(newValue != null) {
                try {
                    carregarFrascos(newValue.getIdVacina());
                } catch (SQLException e) {
                    e.getMessage();
                    e.printStackTrace();
                }
            }
        });
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

        try { 

            Animal animalSelecionado = animalVacinado.getValue();

            Vacina vacinaSelecionada = vacinaAplicada.getValue();

            Frasco frascoSelecionado = frascoAplicado.getValue();

            Veterinario veterinario = identificacaoVeterinario.getValue();

            LocalDate dataDeAplicacao = dataAplicacao.getValue();

            LocalDate dataDeRetorno = dataRetorno.getValue();

            if (animalSelecionado != null && vacinaSelecionada != null ) {
                
                
                    
                    Vacinacao vacinacao = new Vacinacao(
                        animalSelecionado,
                        vacinaSelecionada,
                        veterinario,
                        dataDeAplicacao,
                        dataDeRetorno,
                        0,
                        frascoSelecionado.getIdFrasco()

                    );

                    vacinacaoService.registrarVacinacao(vacinacao);

                    exibirAlerta(AlertType.INFORMATION, "Sucesso", "Frasco cadastrado com sucesso!");

            }catch (ValidationException e) {
       
            exibirAlerta(AlertType.WARNING, "Erro de Validação", e.getMessage());

            } catch (SQLException e) {
                exibirAlerta(AlertType.ERROR, "Erro de Banco de Dados", "Ocorreu um erro ao salvar os dados.");
                e.printStackTrace();

                
            }
        }
    }




    private void configurarComboBoxVeterinarios() {

        identificacaoVeterinario.setConverter(new StringConverter<Veterinario>(){
            @Override
            public String toString(Veterinario veterinario) {
                return veterinario == null ? null : veterinario.getNome();
            }
            @Override
            public Veterinario fromString(String strin) {
                return null;
            }
        });

        identificacaoVeterinario.setCellFactory(param -> new ListCell<Veterinario>() {
            @Override
            protected void updateItem(Veterinario item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNome() + " (CRMV: " + item.getCrmv() + ")");
                }
            }
        });
    }




    private void carregarVeterinarios() throws SQLException {

        try {

            List<Veterinario> veterinarios = veterinarioService.getVeterinariosDisponiveis();
            
            identificacaoVeterinario.getItems().clear();
            identificacaoVeterinario.getItems().setAll(veterinarios);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
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




    private void configurarComboBoxFrascos() {
        
        frascoAplicado.setConverter(new StringConverter<Frasco>() {


            @Override
            public String toString(Frasco frasco) {
                return frasco == null ? "" : frasco.getIdFrasco() + " (" + frasco.getVolumeFrasco() + "ml)";
            }

            @Override
            public Frasco fromString(String string) {
                return null;
            }
        });

        frascoAplicado.setCellFactory(param -> new ListCell<Frasco>() {
            @Override
            protected void updateItem(Frasco item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getIdFrasco() + " (" + item.getVolumeFrasco() + "ml)");
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




    private void carregarFrascos(int idVacina) throws SQLException {

        try {

            List<Frasco> frascos = frascoService.buscarFrascosPorIdVacina(idVacina);

            frascoAplicado.getItems().clear();
            frascoAplicado.getItems().setAll(frascos);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    @FXML
    private void exibirAlerta(AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null); // Sem texto de cabeçalho
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}