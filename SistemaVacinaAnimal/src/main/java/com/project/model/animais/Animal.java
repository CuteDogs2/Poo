package com.project.model.animais;
import java.time.LocalDate;




/**
 * Esta classe representa um animal, e contém informações para a identificação do mesmo e seu dono.
 * 
 * <p>Armazena ID do animal, nome, data de nascimento, sexo, peso, e um objeto cliente que contem as informações de seu dono.</p>
 */
public class Animal{




    //Atributos



    /** ID do animal. */
    private String idAnimal;

    /** Nome do animal. */
    private String nome;

    /** Data de nascimento do animal. */
    private LocalDate dataNascimento;

    /** Sexo do animal. */
    private char sexo;

    /** Peso em kg do animal. */
    private float peso;

    /** Objeto Cliente, que representa o dono do animal. */
    private Cliente dono;




    //Construtor




    /**
     * Construtor da classe Animal.
     * 
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param dono              Cliente que é dono do animal.
     */
    public Animal(String idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, Cliente dono){
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.dono = dono;
    }
    



    //Métodos




    /**
     * Obtém o ID do animal.
     * 
     * @return ID do animal.
     */
    public String getIdAnimal(){
        return this.idAnimal;
    }




    /**
     * Obtém o nome do animal.
     * 
     * @return Nome do animal.
     */
    public String nome(){
        return this.nome;
    }




    /**
     * Obtém a data de nascimento do animal.
     * 
     * @return Data de nascimento do animal.
     */
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }




    /**
     * Obtém o sexo do animal.
     * 
     * @return Sexo do animal.
     */
    public char getSexo(){
        return this.sexo;
    }




    /**
     * Obtém o peso do animal.
     * 
     * @return Peso do animal.
     */
    public float getPeso(){
        return this.peso;
    }




    /**
     * Obtém um objeto Cliente que representa o dono do animal.
     * 
     * @return Dono do animal.
     */
    public Cliente getDono(){
        return this.dono;
    }




    /**
     * Altera o ID do animal.
     * 
     * @param idAnimal Novo ID do animal.
     */
    public void setIdAnimal(String idAnimal){
        this.idAnimal = idAnimal;
    }




    /**
     * Altera o nome do animal.
     * 
     * @param nome Novo nome do animal.
     */
    public void setNome(String nome){
        this.nome = nome;
    }




    /**
     * Altera a data de nascimento do animal.
     * 
     * @param dataNascimento Nova data de nascimento do animal.
     */
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }




    /**
     * Altera o sexo do animal.
     * 
     * @param sexo Novo sexo do animal.
     */
    public void setSexo(char sexo){
        this.sexo = sexo;
    }




    /**
     * Altera o peso do animal.
     * 
     * @param peso Novo peso do animal.
     */
    public void setPeso(float peso){
        this.peso = peso;
    }




    /**
     * Altera o dono do animal.
     * 
     * @param Dono Novo dono do animal.
     */
    public void setDono(Cliente Dono){
        this.dono = dono;
    }
}