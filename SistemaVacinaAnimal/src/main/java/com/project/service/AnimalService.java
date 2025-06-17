package com.project.service;




import com.project.model.Animal;
import com.project.repository.AnimalRepository;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class AnimalService {




    private final AnimalRepository animalRepository = new AnimalRepository();



    public List<Animal> buscarAnimalPorCpfDono(String cpf) throws SQLException {
        
        try {
            return animalRepository.buscarAnimalPorCpfDono(cpf);
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }

    }




    public void cadastrarAnimal(Animal animal) throws SQLException {

        try {
            animalRepository.inserirAnimal(animal);
        
        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }

    }
    
}
