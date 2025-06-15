package com.project.service;


import com.project.model.vacina.Lote;
import com.project.repository.LoteRepository;
import com.project.util.DataBaseUtil;

import java.sql.SQLException;
import java.sql.Connection;


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


    

    public void cadastraLote(Lote lote) throws SQLException{  
        
        
        Connection  conection = null;

        try{
            conection = DataBaseUtil.getConnection();

            loteRepository.inserirLote(lote, conection);
            

        }catch(SQLException e){
            if (conection != null) {
                conection.rollback();
            }

            throw e;
        }
        finally {
            
            if (conection != null) {
                conection.setAutoCommit(true);
                conection.close();
            }
        }

    }
}