package com.project.repository;




import com.project.model.pessoas.Cliente;
import com.project.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class ClienteRepository {

    


    public void inserirCliente(Cliente cliente) throws SQLException {
        

        String sql = "INSERT INTO pessoa (nome, cpf, telefone, email, data_nascimento, sexo) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection connection = DataBaseUtil.getConnection();
        
        inserirCliente(cliente, connection);
        
        /*
        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setDate(5, Date.valueOf(cliente.getDataNascimento()));
            preparedStatement.setString(6, String.valueOf(cliente.getSexo()));

            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        */
    }



    
    public void inserirCliente(Cliente cliente, Connection connection) throws SQLException {


        String sql = "INSERT INTO pessoa (nome, cpf, telefone, email, data_nascimento, sexo) VALUES (?, ?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCpf());
            preparedStatement.setString(3, cliente.getTelefone());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setDate(5, Date.valueOf(cliente.getDataNascimento()));
            preparedStatement.setString(6, String.valueOf(cliente.getSexo()));

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public Cliente buscarClientePorCpf(String cpf) throws SQLException {
        

        String sql = "SELECT nome, cpf, telefone, email, data_nascimento, sexo FROM pessoa WHERE cpf = ? AND funcionario_crmv IS NULL";
        

        Cliente cliente = null;

        
        try(Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, cpf);
            

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()){
                if (resultadoBusca.next()) {

                    cliente = new Cliente(
                        resultadoBusca.getString("nome"),
                        resultadoBusca.getString("cpf"),
                        resultadoBusca.getString("telefone"),
                        resultadoBusca.getString("email"),
                        resultadoBusca.getDate("data_nascimento").toLocalDate(),
                        resultadoBusca.getString("sexo").charAt(0)
                    );
                }
            }
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();

            throw e;

        }

        return cliente;

    }




    public List<Cliente> buscarTodos() throws SQLException {

        String sql = "SELECT nome, cpf, telefone, email, data_nascimento, sexo FROM pessoa WHERE funcionario_crmv IS NULL";


        List<Cliente> clientes = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultadoBusca  = preparedStatement.executeQuery()) {

            while (resultadoBusca.next()) {
                Cliente cliente = new Cliente(
                    resultadoBusca.getString("nome"),
                    resultadoBusca.getString("cpf"),
                    resultadoBusca.getString("telefone"),
                    resultadoBusca.getString("email"),
                    resultadoBusca.getDate("data_nascimento").toLocalDate(),
                    resultadoBusca.getString("sexo").charAt(0)
                );
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;

        }

        return clientes;
    }




    public void atualizarCliente(Cliente cliente) throws SQLException {

        String sql = "UPDATE pessoa SET nome = ?, telefone = ?, email = ?, data_nascimento = ?, sexo = ? WHERE cpf = ?";

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTelefone());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setDate(4, Date.valueOf(cliente.getDataNascimento()));
            preparedStatement.setString(5, String.valueOf(cliente.getSexo()));

            preparedStatement.setString(6, cliente.getCpf());

            preparedStatement.executeUpdate();
        
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();

            throw e;
        }

    }

}
