



/**
 * Classe utilitaria para validação de dados.
 */
public class ValidadorUtil{




    //Métodos validadores de dados




    /**
     * Função para validação de CPF's.
     * 
     * @param cpf CPF a ser validado (no formato String).
     * @return true se o CPF for válido. false caso contrário.
     */
    public static boolean validarCpf(String cpf){
        if(cpf != null && cpf.lenght() == 11){
            return true;
        }
        else return false;
    }




    /**
     * Função para validação de e-mail's.
     * 
     * @param email E-mail a ser validado (em formato String).
     * @return true se o e-mail for válido, false caso contrário.
     */
    public static boolean validarEmail(String email){
        if(email != null && email.contains("@")){
            return true;
        }
        else return false;
    }
}