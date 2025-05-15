



/**
 * Esta classe representa um veterinário, que é subclasse de pessoa, e contém informações para identificação do mesmo.
 * 
 * <p>Além dos dados da classe pessoa, armazena o CRMV do veterinário, e contém métodos de acesso.</p>
 */
public class Veterinario extends Pessoa{




    //Atributos




    /** CRMV do veterinário. */
    private String crmv;




    //Construtor




    /**
     * Construtor da classe Veterinario.
     * 
     * @param crmv              CRMV do veterinário.
     * @param nome              Nome do veterinário.
     * @param cpf               CPF do veterinário.
     * @param dataNascimento    Data de nascimento do veterinário.
     * @param telefone          Telefone do veterinário.
     * @param sexo              Sexo do veterinário (masculino (m)/feminino (f)).
     * @param email             E-mail do veterinário.
     */
    public Veterinario(String crmv, String nome, String cpf, LocalDate dataNascimento, String telefone, char sexo, String email){
        super(nome, cpf, dataNascimento, telefone, sexo, email);
        this.crmv = crmv;
    }




    //Métodos




    /**
     * Obtém o CRMV do veterinário.
     * 
     * @return CRMV do veterinário.
     */
    public String getCrmv(){
        return this.crmv;
    }




    /**
     * Altera o CRMV do veterinário.
     * 
     * @param crmv Novo CRMV.
     */
    public String setCrmv(String crmv){
        this.crmv = crmv;
    }
}