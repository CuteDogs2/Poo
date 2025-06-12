package com.project.util;




import com.project.model.pessoas.Cliente;
import com.project.model.vacina.Frasco;
import com.project.model.vacina.Lote;
import com.project.model.vacina.Vacina;
import com.project.model.Animal;
import com.project.model.Vacinacao;
import com.project.model.pessoas.Veterinario;

import java.sql.ResultSet;





public class ClassMount {

    public Vacinacao vacinacaoMounter(ResultSet resultadoBusca) throws java.sql.SQLException {

        Cliente dono = new Cliente(resultadoBusca.getString("nome_dono"), resultadoBusca.getString("pessoa_cpf"), resultadoBusca.getString("telefone"), resultadoBusca.getString("email"), resultadoBusca.getDate("dono_data_nascimento").toLocalDate(), resultadoBusca.getString("dono_sexo").charAt(0));




        Animal animal = new Animal(resultadoBusca.getString("raca"), resultadoBusca.getInt("idanimal"), resultadoBusca.getString("animal_nome"), resultadoBusca.getDate("data_nascimento_animal").toLocalDate(), resultadoBusca.getString("animal_sexo").charAt(0), resultadoBusca.getFloat("peso"), resultadoBusca.getString("especie"), dono);



        
        Veterinario veterinario = new Veterinario(resultadoBusca.getString("veterinario_crmv"), resultadoBusca.getString("veterinario_nome"));



        
        Frasco frasco = new Frasco(resultadoBusca.getString("id_frasco"), resultadoBusca.getFloat("volume_frasco"));



        
        Lote lote = new Lote(resultadoBusca.getString("id_lote"), resultadoBusca.getDate("lote_data_validade").toLocalDate());
        
        lote.getFrascos().add(frasco);



        
        Vacina vacina = new Vacina(resultadoBusca.getString("vacina_nome"), resultadoBusca.getString("vacina_fabricante"), resultadoBusca.getInt("vacina_validade_aplicacao"),resultadoBusca.getFloat("vacina_dosagem"));

        vacina.getLotes().add(lote);




        Vacinacao vacinacao = new Vacinacao(animal, vacina, veterinario, resultadoBusca.getDate("dataAplicacao").toLocalDate(), 
            (resultadoBusca.getDate("dataRetorno") != null ? resultadoBusca.getDate("dataRetorno").toLocalDate() : null),
        resultadoBusca.getFloat("dose_aplicada"), resultadoBusca.getString("id_frasco"));

     
        return vacinacao;
    }
    
}
