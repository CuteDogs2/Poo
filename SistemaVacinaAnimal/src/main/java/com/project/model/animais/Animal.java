package com.project.model.animais;




import com.project.model.pessoas.Cliente;
import java.time.LocalDate;




/**
 * Esta classe representa um animal, e contém informações para a identificação do mesmo e seu dono.
 * 
 * <p>Armazena ID do animal, nome, data de nascimento, sexo, peso, e um objeto cliente que contem as informações de seu dono.</p>
 */
abstract public class Animal {




    //Atributos



    /** ID do animal. */
    private int idAnimal;

    /** Nome do animal. */
    private String nome;

    /** Data de nascimento do animal. */
    private LocalDate dataNascimento;

    /** Sexo do animal. */
    private char sexo;

    /** Peso em kg do animal. */
    private float peso;

    /** Espécie do animal */
    private String especie;

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
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Animal(int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.especie = especie;
        this.dono = dono;
    }




    /**
     * Construtor da classe Animal.
     * 
     * <p>Utilizado para criar um animal sem o ID.</p>
     * 
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Animal(String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.especie = especie;
        this.dono = dono;
    }




    /**
     * Construtor da classe Animal.
     * 
     * <p>Construtor utilizado para criar um animal sem o dono</p>
     * 
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     */
    public Animal(int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.peso = peso;
        this.especie = especie;
    }
    



    //Métodos




    /**
     * Obtém o ID do animal.
     * 
     * @return ID do animal.
     */
    public int getIdAnimal() {
        return this.idAnimal;
    }




    /**
     * Obtém o nome do animal.
     * 
     * @return Nome do animal.
     */
    public String getNome() {
        return this.nome;
    }




    /**
     * Obtém a data de nascimento do animal.
     * 
     * @return Data de nascimento do animal.
     */
    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }




    /**
     * Obtém o sexo do animal.
     * 
     * @return Sexo do animal.
     */
    public char getSexo() {
        return this.sexo;
    }




    /**
     * Obtém o peso do animal.
     * 
     * @return Peso do animal.
     */
    public float getPeso() {
        return this.peso;
    }




    /**
     * Obtém a espécie do animal.
     * 
     * @return Espécie do animal.
     */
    public String getEspecie() {
        return this.especie;
    }



    /**
     * Obtém um objeto Cliente que representa o dono do animal.
     * 
     * @return Dono do animal.
     */
    public Cliente getDono() {
        return this.dono;
    }




    /**
     * Altera o ID do animal.
     * 
     * @param idAnimal Novo ID do animal.
     */
    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }




    /**
     * Altera o nome do animal.
     * 
     * @param nome Novo nome do animal.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }




    /**
     * Altera a data de nascimento do animal.
     * 
     * @param dataNascimento Nova data de nascimento do animal.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }




    /**
     * Altera o sexo do animal.
     * 
     * @param sexo Novo sexo do animal.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }




    /**
     * Altera o peso do animal.
     * 
     * @param peso Novo peso do animal.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }




    /**
     * Altera a espécie do animal.
     * 
     * @param especie Nova espécie do animal.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }




    /**
     * Altera o dono do animal.
     * 
     * @param Dono Novo dono do animal.
     */
    public void setDono(Cliente dono) {
        this.dono = dono;
    }
}