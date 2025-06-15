package com.project.service;


import com.project.model.vacina.Lote;
import com.project.repository.LoteRepository;
import com.project.util.DataBaseUtil;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;


public class LoteService{




    //Atributos
    private LoteRepository loteRepository;

    


    //Construtor

    public LoteService(LoteRepository loteRepository){
        this.loteRepository = loteRepository;
    }




    public LoteService(){
        this.loteRepository = new LoteRepository();
    }


    

    public void cadastraLote(Lote lote) throws SQLException {  
        
        


        try{

            loteRepository.inserirLote(lote);
            
        } catch (SQLException e){
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }




    public List<Lote> buscarLotesDisponiveis() throws SQLException {




        try {
            
            return loteRepository.buscarTodosLotes();

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();

            throw e;
        }
    }
}