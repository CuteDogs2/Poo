package com.project.model.pessoas;




import java.time.LocalDate;
import com.project.model.animais.Animal;
import java.util.List;




/**
 * Esta classe representa um cliente, que é uma subclasse de pessoa, e contém informações para identificação do mesmo.
 * 
 * <p>Além dos dados da classe Pessoa, armazena um ID único do animal do cliente, e contém métodos de acesso.</p>
 */
public class Cliente extends Pessoa {




    //Atributos





    /** Id do animal. */
    private List<Animal> listaAnimais;




    //Construtor




    /**
     * Construtor da classe Cliente.
     * 
     * @param listaAnimais      Lista de animais do cliente.
     * @param nome              Nome do cliente.
     * @param cpf               CPF do cliente.
     * @param telefone          Telefone do cliente.
     * @param email             E-mail do cliente.
     * @param dataNascimento    Data de nascimento do cliente.
     * @param sexo              Sexo do cliente (masculino (m)/feminino (f)).
     */
    public Cliente(List<Animal> listaAnimais, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, char sexo) {
        super(nome, cpf, telefone, email, dataNascimento, sexo);
        this.listaAnimais = listaAnimais;
    }




    /**
     * Construtor da classe Cliente.
     * 
     * <p>Utilizado para criar um cliente sem a lista de animais.</p>
     */
    public Cliente(String nome, String cpf, String telefone, String email, LocalDate dataNascimento, char sexo) {
    super(nome, cpf, telefone, email, dataNascimento, sexo);
    }




    //Métodos


    

    /**
     * Obtém a lista de animais do cliente.
     *
     * @return Lista de animais.
     */
    public List<Animal> getListaAnimais() {
        return this.listaAnimais;
    }




    /**
     * Altera a lista de animais do cliente.
     *
     * @param listaAnimais Lista de animais.
     */
    public void setListaAnimais(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }
}