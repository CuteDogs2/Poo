package com.project.model.animais;




import com.project.model.pessoas.Cliente;
import java.time.LocalDate;




/**
 * Esta classe representa um animal da espécie ave, e contém informações para identificação do mesmo.
 * 
 * <p>Alem dos dados da classe animal, armazena a raça da ave, e contém métodos de acesso.</p>
 */
public class Ave extends Animal {




    //Atributos




    /** Raça da ave. */
    private String raca;




    //Construtor




    /**
     * Construtor da classe Ave.
     * 
     * @param raca              Raça da ave.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Ave(String raca, int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        super(idAnimal, nome, dataNascimento, sexo, peso, especie, dono);
        this.raca = raca;
    }




    /**
     * Construtor da classe Ave.
     * 
     * <p>Utilizado para criar um canino sem o ID.</p>
     * 
     * @param raca              Raça da ave.
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     * @param dono              Cliente que é dono do animal.
     */
    public Ave(String raca, String nome, LocalDate dataNascimento, char sexo, float peso, String especie, Cliente dono) {
        super(nome, dataNascimento, sexo, peso, especie, dono);
        this.raca = raca;
    }




    /**
     * Construtor da classe Ave.
     * 
     * <p>Construtor utilizado para criar um Ave sem o dono</p>
     * 
     * @param raca              Raça do Ave.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param especie           Espécie do animal.
     */
    public Ave(String raca, int idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, String especie) {
        super(idAnimal, nome, dataNascimento, sexo, peso, especie);
        this.raca = raca;
    }




    //Métodos




    /**
     * Obtém a raça da ave.
     * 
     * @return Raça da ave.
     */
    public String getRaca() {
        return this.raca;
    }




    /**
     * Altera a raça da ave.
     * 
     * @param raca Nova raça da ave.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }
}