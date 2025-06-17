package com.project.tasks;

import java.sql.SQLException;

import com.project.controller.CadastrarClienteController;
import com.project.model.pessoas.Cliente;

import javafx.concurrent.Task;

import com.project.service.ClienteService;

public class ClienteTask {

        private final ClienteService clienteService = new ClienteService();
        private final CadastrarClienteController cadastrarClienteController;




        //Construtor




        public ClienteTask(CadastrarClienteController cadastrarClienteController) {
            this.cadastrarClienteController = cadastrarClienteController;
        }
        


        public void buscarClientePorCpf(final String cpf){

        Task<Cliente> buscarTask = new Task<>() {
        
            @Override
            protected Cliente call() throws SQLException {

                Cliente cliente  = clienteService.buscarClientePorCpf(cpf);

                return cliente;

            }
        };
        buscarTask.setOnSucceeded(event -> {
            
            Cliente cliente = buscarTask.getValue();

            if (cliente != null) {
                cadastrarClienteController.preencherCamposClienteCadastrado(cliente);
            }
        });
    
        new Thread(buscarTask).start();
    }
    
}
