package com.project.model.pessoas;
import java.time.LocalDate;




/**
 * Esta classe representa uma pessoa, e contém as informações pessoais básicas da mesma.
 * 
 * <p>Armazena nome, CPF, data de nascimento, telefone, sexo, e-mail, e contém métodos de acesso.</p>
 */
public class Pessoa {




    //Atributos




    /** Nome da pessoa. */
    private String nome;

    /** CPF da pessoa. */
    private String cpf;

    /** Data de nascimento da pessoa. */
    private LocalDate dataNascimento;

    /** Telefone da pessoa. */
    private String telefone;

    /** Sexo da pessoa. */
    private char sexo;

    /** E-mail da pessoa. */
    private String email;




    //Construtor




    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome                  Nome da pessoa.
     * @param cpf                   CPF da pessoa.
     * @param dataNascimento        Idade da pessoa.
     * @param telefone              Telefone da pessoa.
     * @param sexo                  Sexo da pessoa (masculino (m)/feminino (f)).
     * @param email                 E-mail da pessoa
     */
    public Pessoa(String nome, String cpf, LocalDate dataNascimento, String telefone, char sexo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.email = email;
    }




    //Métodos




    /**
     * Obtém o nome da pessoa.
     * 
     * @return Nome da pessoa.
     */
    public String getNome() {
        return this.nome;
    }

    

    
    /**
     * Obtém o CPF da pessoa.
     * 
     * @return CPF da pessoa.
     */
    public String getCpf(){
        return this.cpf;
    }




    /**
     * Obtém a data de nascimento da pessoa.
     * 
     * @return Data de nascimento da pessoa.
     */
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }




    /**
     * Obtém o telefone da pessoa.
     * 
     * @return Telefone da pessoa.
     */
    public String getTelefone() {
        return this.telefone;
    }




    /**
     * Obtém o sexo da pessoa.
     * 
     * @return Sexo da pessoa.
     */
    public char getSexo() {
        return this.sexo;
    }
    



    /**
     * Obtem o e-mail da pessoa.
     * 
     * 
     * @return E-mail da pessoa.
     */
    public String getEmail(){
        return this.email;
    }




    /**
     * Altera o nome da pessoa.
     * 
     * @param nome Novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    


    /**
     * Altera o CPF da pessoa.
     * 
     * @param cpf Novo CPF da pessoa.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




    /**
     * Altera a data de nascimento da pessoa.
     * 
     * @param dataNascimento Nova data de nascimento da pessoa.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }




    /**
     * Altera o telefone da pessoa.
     * 
     * @param telefone Novo telefone da pessoa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }




    /**
     * Altera o sexo da pessoa.
     * 
     * @param sexo Novo sexo da pessoa.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }




    /**
     * Altera o e-mail da pessoa.
     * 
     * @param email Novo e-mail da pessoa.
     */
    public void setEmail(String email){
        this.email = email;
    }
}