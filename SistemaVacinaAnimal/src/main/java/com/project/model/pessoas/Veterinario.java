



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




    public Veterinario(String crmv, String nome, String cpf, int dataNascimento, String telefone, String sexo, String email){
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
     * Altera o CRMV do cliente.
     * 
     * @param crmv Novo CRMV.
     */
    public String setCrmv(String crmv){
        this.crmv = crmv;
    }
}