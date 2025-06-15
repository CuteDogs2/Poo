package com.project.service;





import com.project.model.vacina.Frasco;
import com.project.repository.FrascoRepository;
import com.project.util.DataBaseUtil;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;


public class FrascoService {

    


    //Atributos


    

    private FrascoRepository frascoRepository;




    //Construtores




    public FrascoService(FrascoRepository frascoRepository) {
        this.frascoRepository = frascoRepository;
    }


    

    public FrascoService(){
        this.frascoRepository = new FrascoRepository();
    }




    //Métodos


    

    public void cadastrarFrasco(Frasco frasco) throws SQLException {




        try{
            
            frascoRepository.inserirFrasco(frasco);
            
        } catch(SQLException e){
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public List<Frasco> buscarFrascosPorIdVacina(int idVacina) throws SQLException {




        try {

            return frascoRepository.buscarPorIdVacina(idVacina);

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }
}
