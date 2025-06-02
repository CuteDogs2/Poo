package com.project;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/master.fxml"));
        primaryStage.setTitle("Sistema Vacina Animal");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {



        // Testa a conexão com o banco de dados
        try (java.sql.Connection conn = com.project.util.DataBaseUtil.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("erro ao conectar: " + e.getMessage());
            e.printStackTrace();
        }




        launch(args);
    }
}