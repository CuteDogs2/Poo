package com.project.repository;




import com.project.util.DataBaseUtil;
import com.project.model.animais.Animal;
import com.project.model.animais.Canino;
import com.project.model.animais.Felino;
import com.project.model.animais.Ave;

import java.sql.*;




public class AnimalRepository {




    public void inserirAnimal(Animal animal) {


        String sql = "INSERT INTO animal (nome, data_nascimento, sexo, peso, especie, raca, pessoa_cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";


        try (Connection connection = DataBaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setDate(2, Date.valueOf(animal.getDataNascimento()));
            preparedStatement.setString(3, String.valueOf(animal.getSexo()));
            preparedStatement.setFloat(4, animal.getPeso());
            
            String especie = "";
            if (animal instanceof Canino) {
                especie = "Canino";
            }
            if (animal instanceof Felino) {
                especie = "Felino";
            }
            if (animal instanceof Ave) {
                especie = "Ave";
            }
            preparedStatement.setString(5, especie);

            
            

        }

    }

}
    
