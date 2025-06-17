package com.project.service;




import com.project.model.Animal;
import com.project.model.pessoas.Cliente;
import com.project.repository.AnimalRepository;
import com.project.repository.ClienteRepository;
import com.project.util.DataBaseUtil;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;




public class ClienteService {




    //Atributos




    private ClienteRepository clienteRepository;
    private AnimalRepository animalRepository;




    //Construtor




    public ClienteService(ClienteRepository clienteRepository, AnimalRepository animalRepository) {
        this.clienteRepository = clienteRepository;
        this.animalRepository = animalRepository;
    }




    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
        this.animalRepository = new AnimalRepository();
    }




    //Métodos




    public void cadastrarClienteEAnimal(Cliente cliente, Animal animal) throws SQLException {
        
        Connection connection = null;

        try {
            
            connection = DataBaseUtil.getConnection();

            connection.setAutoCommit(false);

            clienteRepository.inserirCliente(cliente, connection);

            animalRepository.inserirAnimal(animal, connection);

            connection.commit();

        } catch (SQLException e) {

            if (connection != null) {
                connection.rollback();
            }

            throw e;

        } finally {
            
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }




    public List<Cliente> buscarTodos() throws SQLException{
        return clienteRepository.buscarTodos();
    }




    public Cliente buscarClientePorCpf(String cpf) throws SQLException{
        return clienteRepository.buscarClientePorCpf(cpf);
    }

}