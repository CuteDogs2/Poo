package com.project.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.Node;




public class MasterController implements MenuController.Listener {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox sidebarvbox;

    @FXML
    private VBox area_conteudo;

    @FXML
    private MenuController menuInclude;

    @FXML
    void initialize() {
        assert sidebarvbox != null : "fx:id=\"sidebarvbox\" was not injected: check your FXML file 'master.fxml'.";
        assert area_conteudo != null : "fx:id=\"area_conteudo\" was not injected: check your FXML file 'master.fxml'.";

        menuInclude.setListener(this);
    }

    @Override
    public void onMenuItem(String fxml) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("/com/project/view/" + fxml));
            area_conteudo.getChildren().setAll(node);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
