package com.project.model.pessoas;




import java.time.LocalDate;




/**
 * Esta classe representa um cliente, que é uma subclasse de pessoa, e contém informações para identificação do mesmo.
 * 
 * <p>Além dos dados da classe Pessoa, armazena um ID único do animal do cliente, e contém métodos de acesso.</p>
 */
public class Cliente extends Pessoa {




    //Atributos





    /** Id do animal. */
    private String idAnimal;




    //Construtor




    /**
     * Construtor da classe Cliente.
     * 
     * @param idAnimal          Id do animal.
     * @param nome              Nome do cliente.
     * @param cpf               CPF do cliente.
     * @param dataNascimento    Data de nascimento do cliente.
     * @param telefone          Telefone do cliente.
     * @param sexo              Sexo do cliente (masculino (m)/feminino (f)).
     * @param email             E-mail do cliente.
     */
    public Cliente(String idAnimal, String nome, String cpf, LocalDate dataNascimento, String telefone, char sexo, String email) {
        super(nome, cpf, dataNascimento, telefone, sexo, email);
        this.idAnimal = idAnimal;
    }




    //Métodos



    
    /**
     * Obtém o ID do animal do cliente.
     * 
     * @return ID do animal.
     */
    public String getIdAnimal() {
        return this.idAnimal;
    }




    /**
     * Altera o ID do animal do cliente.
     * 
     * @param idAnimal ID do animal.
     */
    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }
}