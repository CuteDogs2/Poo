package com.project.model.pessoas;




import java.time.LocalDate;




/**
 * Esta classe representa um veterinário, que é subclasse de pessoa, e contém informações para identificação do mesmo.
 * 
 * <p>Além dos dados da classe pessoa, armazena o CRMV do veterinário, e contém métodos de acesso.</p>
 */
public class Veterinario extends Pessoa {




    //Atributos




    /** CRMV do veterinário. */
    private String crmv;




    //Construtor




    /**
     * Construtor da classe Veterinario.
     * 
     * @param crmv              CRMV do veterinário.
     * @param nome              Nome do cliente.
     * @param cpf               CPF do cliente.
     * @param telefone          Telefone do cliente.
     * @param email             E-mail do cliente.
     * @param dataNascimento    Data de nascimento do cliente.
     * @param sexo              Sexo do cliente (masculino (m)/feminino (f)).
     */
    public Veterinario(String crmv, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, char sexo) {
        super(nome, cpf, telefone, email, dataNascimento, sexo);
        this.crmv = crmv;
    }




    /**
     * Construtor da classe Veterinario.
     * 
     * @param crmv              CRMV do veterinário.
     * @param nome              Nome do cliente.
     * @param cpf               CPF do cliente.
     * @param telefone          Telefone do cliente.
     * @param email             E-mail do cliente.
     * @param dataNascimento    Data de nascimento do cliente.
     * @param sexo              Sexo do cliente (masculino (m)/feminino (f)).
     */
    public Veterinario(String crmv, String nome) {
        super(nome);
        this.crmv = crmv;
    }




    //Métodos




    /**
     * Obtém o CRMV do veterinário.
     * 
     * @return CRMV do veterinário.
     */
    public String getCrmv() {
        return this.crmv;
    }




    /**
     * Altera o CRMV do veterinário.
     * 
     * @param crmv Novo CRMV.
     */
    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
}