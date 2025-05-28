package com.project.controller;

import javafx.fxml.FXML;

public class MenuController {

    public interface Listener { void onMenuItem(String fxml); }
    private Listener listener;
    public void setListener(Listener l) {listener = l;}

    @FXML void onPaginaInicialClicked() { if (listener != null) listener.onMenuItem("home.fxml"); }
    @FXML void onVacinasClicked() { if (listener != null) listener.onMenuItem("vacinas.fxml"); }
    @FXML void onTutoresClicked() { if (listener != null) listener.onMenuItem("clientes.fxml"); }
    @FXML void onRegistrarVacinacaoClicked() { if (listener != null) listener.onMenuItem("registrarVacinacao.fxml"); }
    @FXML void onCadastrarTutorClicked() { if (listener != null) listener.onMenuItem("cadastrarCliente.fxml"); }
}