package com.project.model.animais;




import com.project.model.pessoas.Cliente;
import java.time.LocalDate;




/**
 * Esta classe representa um animal da espécie canino, e contém informações para identificação do mesmo.
 * 
 * <p>Alem dos dados da classe animal, armazena a raça do canino, e contém métodos de acesso.</p>
 */
public class Canino extends Animal {




    //Atributos




    /** Raça do canino. */
    private String raca;




    //Construtor




    /**
     * Construtor da classe Canino.
     * 
     * @param raca              Raça do canino.
     * @param idAnimal          ID do animal
     * @param nome              Nome do animal.
     * @param dataNascimento    Data de nascimento do animal.
     * @param sexo              Sexo do animal (macho (m)/fêmea(f)).
     * @param peso              Peso do animal em kg.
     * @param dono              Cliente que é dono do animal.
     */
    public Canino(String raca, String idAnimal, String nome, LocalDate dataNascimento, char sexo, float peso, Cliente dono) {
        super(idAnimal, nome, dataNascimento, sexo, peso, dono);
        this.raca = raca;
    }




    /**
     * Obtém a raça do canino.
     * 
     * @return Raça do canino.
     */
    public String getRaca() {
        return this.raca;
    }




    /**
     * Altera a raça do canino.
     * 
     * @param raca Nova raça do canino.
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }
}