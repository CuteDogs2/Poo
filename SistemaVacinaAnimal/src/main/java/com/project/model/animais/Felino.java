package com.project.model.animais;




import com.project.model.pessoas.Cliente;
import java.time.LocalDate;




/**
 * Esta classe representa um animal da espécie felino, e contém informações para identificação do mesmo.
 * 
 * <p>Alem dos dados da classe animal, armazena a raça do felino, e contém métodos de acesso.</p>
 */
public class Felino extends Animal {




    //Atributos




    /** Raça do felino. */
    private String raca;




    //Construtor




    /**
     * Construtor da classe felino.
     * 
     * @param raca              Raça do felino.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Felino(String raca, int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        super(idAnimal, nome, dataNascimento, sexo, peso, especie, dono);
        this.raca = raca;
    }




    /**
     * Construtor da classe Felino.
     * 
     * <p>Utilizado para criar um canino sem o ID.</p>
     * 
     * @param raca              Raça do Felino.
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Felino(String raca, String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        super(nome, dataNascimento, sexo, peso, especie, dono);
        this.raca = raca;
    }




    /**
     * Construtor da classe Felino.
     * 
     * <p>Construtor utilizado para criar um Felino sem o dono</p>
     * 
     * @param raca              Raça do Felino.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     */
    public Felino(String raca, int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie) {
        super(idAnimal, nome, dataNascimento, sexo, peso, especie);
        this.raca = raca;
    }




    //Métodos




    /**
     * Obtém a raça do felino.
     * 
     * @return Raça do felino.
     */
    public String getRaca() {
        return this.raca;
    }




    /**
     * Altera a raça do felino.
     * 
     * @param raca Nova raça do felino.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }
}