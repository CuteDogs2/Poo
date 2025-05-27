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
    private VBox menuInclude;

    @FXML
    void initialize() {
        assert sidebarvbox != null : "fx:id=\"sidebarvbox\" was not injected: check your FXML file 'master.fxml'.";
        assert area_conteudo != null : "fx:id=\"area_conteudo\" was not injected: check your FXML file 'master.fxml'.";
        assert menuInclude != null : "fx:id=\"menuInclude\" was not injected: check yout FXML file 'master.fxml'.";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
            VBox menubox = loader.load();
            MenuController menuController = loader.getController();
            menuController.setListener(this);

            int idx = sidebarvbox.getChildren().indexOf(menuInclude);
            sidebarvbox.getChildren().set(idx, menubox);
        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/menu.fxml"));
            VBox menuBox = loader.load();
            MenuController menuController = loader.getController();
            menuController.setListener(this);

            sidebarvbox.getChildren().add(menuBox);
        } catch(Exception e) {
            e.printStackTrace();
        }
*/
    }

    @Override
    public void onMenuItem(String fxml) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("/view/" + fxml));
            area_conteudo.getChildren().setAll(node);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
