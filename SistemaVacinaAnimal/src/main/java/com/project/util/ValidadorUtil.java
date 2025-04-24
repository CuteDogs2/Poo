public class ValidadorUtil{

    /**
     * Classe utilitária para validação de dados.
    */

    // metodos validadores de dados




    /**
     * Função para validação de cpf's.
     * 
     * @param cpf a ser validado (no formato String).
     * @return true se o cpf for válido. false caso contrário.
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
     * @param email a ser validado (em formato String).
     * @return true se o e-mail for válido, false caso contrário.
     */
    public static boolean validarEmail(String email){

        if(email != null && email.contains("@")){
            return true;
        }
        
        else return false;
        
    }

}