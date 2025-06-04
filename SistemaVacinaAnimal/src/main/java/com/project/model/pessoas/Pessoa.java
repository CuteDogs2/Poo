package com.project.model.pessoas;




import java.time.LocalDate;




/**
 * Esta classe representa uma pessoa, e contém as informações pessoais básicas da mesma.
 * 
 * <p>Armazena nome, CPF, data de nascimento, telefone, sexo, e-mail, e contém métodos de acesso.</p>
 */
abstract class Pessoa {




    //Atributos




    /** Nome da pessoa. */
    private String nome;

    /** CPF da pessoa. */
    private String cpf;

    /** Telefone da pessoa. */
    private String telefone;

        /** E-mail da pessoa. */
    private String email;

    /** Data de nascimento da pessoa. */
    private LocalDate dataNascimento;
    
    /** Sexo da pessoa. */
    private char sexo;












    //Construtor




    /**
     * Construtor da classe Pessoa.
     * 
     * @param nome                  Nome da pessoa.
     * @param cpf                   CPF da pessoa.
     * @param telefone              Telefone da pessoa.
     * @param email                 E-mail da pessoa
     * @param dataNascimento        Idade da pessoa.
     * @param sexo                  Sexo da pessoa (masculino (m)/feminino (f)).
     * 
     */
    public Pessoa(String nome, String cpf, String telefone, String email, LocalDate dataNascimento, char sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        
    }




    /**
     * Construtor da classe Pessoa.
     * 
     * <p>Utilizado para criar uma pessoa somente com seu cpf</p>
     * 
     * @param cpf                   CPF da pessoa.
     * 
     */
    public Pessoa(String cpf) {
        this.cpf = cpf;
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
    public String getCpf() {
        return this.cpf;
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
     * Obtem o e-mail da pessoa.
     * 
     * 
     * @return E-mail da pessoa.
     */
    public String getEmail() {
        return this.email;
    }




    /**
     * Obtém a data de nascimento da pessoa.
     * 
     * @return Data de nascimento da pessoa.
     */
    public LocalDate getDataNascimento() {
        return this.dataNascimento;
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
     * Altera o telefone da pessoa.
     * 
     * @param telefone Novo telefone da pessoa.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }




    /**
     * Altera o e-mail da pessoa.
     * 
     * @param email Novo e-mail da pessoa.
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Altera o sexo da pessoa.
     * 
     * @param sexo Novo sexo da pessoa.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}