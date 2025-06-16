package com.project.service;




import com.project.model.vacina.Vacina;
import com.project.repository.VacinaRepository;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;




public class VacinaService {




    private VacinaRepository vacinaRepository;




    public VacinaService() {
        this.vacinaRepository = new VacinaRepository();
    }




    public void cadastrarVacina(Vacina vacina) throws SQLException {

        try {

            vacinaRepository.inserirVacina(vacina);
            
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public List<Vacina> getVacinasDisponiveis() throws SQLException {

        try {

            return vacinaRepository.buscarTodasVacinas();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }
    
}
