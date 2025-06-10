package com.project.repository;




import com.project.util.DataBaseUtil;
import com.project.model.Animal;
import com.project.model.pessoas.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class AnimalRepository {




    public void inserirAnimal(Animal animal) throws SQLException {


        String sql = "INSERT INTO animal (nome, data_nascimento_animal, sexo, peso, especie, raca, pessoa_cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DataBaseUtil.getConnection();

        inserirAnimal(animal, connection);

        /*
        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setDate(2, Date.valueOf(animal.getDataNascimento()));
            preparedStatement.setString(3, String.valueOf(animal.getSexo()));
            preparedStatement.setFloat(4, animal.getPeso());
            preparedStatement.setString(5, animal.getEspecie());
            preparedStatement.setString(6, animal.getRaca());

            preparedStatement.setString(7, animal.getDono().getCpf());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        */

    }




    public void inserirAnimal(Animal animal, Connection connection) throws SQLException {


        String sql = "INSERT INTO animal (nome, data_nascimento_animal, sexo, peso, especie, raca, pessoa_cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setDate(2, Date.valueOf(animal.getDataNascimento()));
            preparedStatement.setString(3, String.valueOf(animal.getSexo()));
            preparedStatement.setFloat(4, animal.getPeso());
            preparedStatement.setString(5, animal.getEspecie());
            preparedStatement.setString(6, animal.getRaca());
            preparedStatement.setString(7, animal.getDono().getCpf());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public Animal buscarAnimalPorId(int idDoAnimal) throws SQLException {

        String sql = "SELECT a.raca, a.idanimal, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo FROM animal a JOIN pessoa p ON a.pessoa_cpf = p.cpf WHERE a.idanimal = ?";

        Animal animal = null;

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, idDoAnimal);

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                if (resultadoBusca.next()){
                    
                    int idAnimal = resultadoBusca.getInt("idanimal");
                    String raca = resultadoBusca.getString("raca");
                    String animal_nome = resultadoBusca.getString("animal_nome");
                    LocalDate dataNascimentoAnimal = resultadoBusca.getDate("data_nascimento_animal").toLocalDate();
                    char animal_sexo = resultadoBusca.getString("animal_sexo").charAt(0);
                    float peso = resultadoBusca.getFloat("peso");
                    String especie = resultadoBusca.getString("especie");


                    String donoNome = resultadoBusca.getString("nome_dono");
                    String cpfNome = resultadoBusca.getString("pessoa_cpf");
                    String telefone = resultadoBusca.getString("telefone");
                    String email = resultadoBusca.getString("email");
                    LocalDate data_nascimento_dono = resultadoBusca.getDate("dono_data_nascimento").toLocalDate();
                    char sexo_dono = resultadoBusca.getString("dono_sexo").charAt(0);
                    
                    Cliente dono = new Cliente(donoNome, cpfNome, telefone, email, data_nascimento_dono, sexo_dono);

                    animal = new Animal(raca, idAnimal, animal_nome, dataNascimentoAnimal, animal_sexo, peso, especie, dono);
                }
            } 
        } catch (SQLException e) {
                e.getMessage();
                e.printStackTrace();

                throw e;
                
        }

        return animal;
    }




    public List<Animal> buscarAnimalPorCpfDono(String cpf) throws SQLException {

        String sql = "SELECT a.idanimal, a.raca, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo FROM animal a JOIN pessoa p ON a.pessoa_cpf = p.cpf WHERE a.pessoa_cpf = ?";

        List<Animal> animais = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cpf);

            try (ResultSet resultadoBusca = preparedStatement.executeQuery()) {

                while (resultadoBusca.next()) {

                    int idAnimal = resultadoBusca.getInt("idanimal");
                    String raca = resultadoBusca.getString("raca");
                    String animal_nome = resultadoBusca.getString("animal_nome");
                    LocalDate dataNascimentoAnimal = resultadoBusca.getDate("data_nascimento_animal").toLocalDate();
                    char animal_sexo = resultadoBusca.getString("animal_sexo").charAt(0);
                    float peso = resultadoBusca.getFloat("peso");
                    String especie = resultadoBusca.getString("especie");

                    String donoNome = resultadoBusca.getString("nome_dono");
                    String cpfNome = resultadoBusca.getString("pessoa_cpf");
                    String telefone = resultadoBusca.getString("telefone");
                    String email = resultadoBusca.getString("email");
                    LocalDate data_nascimento_dono = resultadoBusca.getDate("dono_data_nascimento").toLocalDate();
                    char sexo_dono = resultadoBusca.getString("dono_sexo").charAt(0);

                    Cliente dono = new Cliente(donoNome, cpfNome, telefone, email, data_nascimento_dono, sexo_dono);
                    
                    Animal animalEncontrado = null;

                    animalEncontrado = new Animal(raca, idAnimal, animal_nome, dataNascimentoAnimal, animal_sexo, peso, especie, dono);

                    if (animalEncontrado != null) {
                        animais.add(animalEncontrado);
                    }
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
        return animais;
    }




    public List<Animal> buscarTodos() throws SQLException {
        
        String sql = "SELECT a.idanimal, a.raca, a.nome AS animal_nome, a.data_nascimento_animal, a.sexo AS animal_sexo, a.peso, a.especie, p.nome AS nome_dono, p.cpf AS pessoa_cpf, p.telefone, p.email, p.data_nascimento AS dono_data_nascimento, p.sexo AS dono_sexo FROM animal a JOIN pessoa p ON a.pessoa_cpf = p.cpf";

        List<Animal> animais = new ArrayList<>();

        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet resultadoBusca = preparedStatement.executeQuery()) {

            while (resultadoBusca.next()) {

                int idAnimal = resultadoBusca.getInt("idanimal");
                String raca = resultadoBusca.getString("raca");
                String animal_nome = resultadoBusca.getString("animal_nome");
                LocalDate dataNascimentoAnimal = resultadoBusca.getDate("data_nascimento_animal").toLocalDate();
                char animal_sexo = resultadoBusca.getString("animal_sexo").charAt(0);
                float peso = resultadoBusca.getFloat("peso");
                String especie = resultadoBusca.getString("especie");

                String donoNome = resultadoBusca.getString("nome_dono");
                String cpfNome = resultadoBusca.getString("pessoa_cpf");
                String telefone = resultadoBusca.getString("telefone");
                String email = resultadoBusca.getString("email");
                LocalDate data_nascimento_dono = resultadoBusca.getDate("dono_data_nascimento").toLocalDate();
                char sexo_dono = resultadoBusca.getString("dono_sexo").charAt(0);

                Cliente dono = new Cliente(donoNome, cpfNome, telefone, email, data_nascimento_dono, sexo_dono);

                Animal animalEncontrado = null;

                animalEncontrado = new Animal(raca, idAnimal, animal_nome, dataNascimentoAnimal, animal_sexo, peso, especie, dono);
                
                if (animalEncontrado != null) {
                    animais.add(animalEncontrado);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }

        return animais;
    }




    public void atualizarAnimal(Animal animal) throws SQLException {

        String sql = "UPDATE animal SET raca = ?, nome = ?, data_nascimento_animal = ?, sexo = ?, peso = ?, especie = ?, pessoa_cpf = ? WHERE idanimal = ?";


        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, animal.getRaca());
            preparedStatement.setString(2, animal.getNome());
            preparedStatement.setDate(3, Date.valueOf(animal.getDataNascimento()));
            preparedStatement.setString(4, String.valueOf(animal.getSexo()));
            preparedStatement.setFloat(5, animal.getPeso());
            preparedStatement.setString(6, animal.getEspecie());
            preparedStatement.setString(7, animal.getDono().getCpf());

            preparedStatement.setInt(8, animal.getIdAnimal());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }
}