package com.project.service;





import com.project.model.vacina.Frasco;
import com.project.repository.FrascoRepository;
import com.project.util.DataBaseUtil;

import java.sql.SQLException;
import java.sql.Connection;


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

        Connection connection = null;

        try{
            connection = DataBaseUtil.getConnection();

            frascoRepository.inserirFrasco(frasco, connection);
            
            
        } catch(SQLException e){
            if (connection != null) {
                connection.rollback();
            }

            throw e;
        }
        finally {
            
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
    }
}
