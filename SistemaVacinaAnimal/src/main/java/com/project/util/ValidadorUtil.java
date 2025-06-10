package com.project.util;
import java.util.regex.Pattern;


/**
 * Classe utilitaria para validação de dados.
 */
public class ValidadorUtil {




    //Métodos validadores de dados




    /**
     * Função para validação de CPF's.
     * 
     * @param cpf CPF a ser validado (no formato String).
     * @return true se o CPF for válido. false caso contrário.
     */
    public boolean validarCpf(String cpf) {
        if(cpf != null && cpf.length() == 11) {
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




    private static final Pattern PADRAO_EMAIL_VALIDO =  Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);




    /**
     * @param email E-mail a ser validado (em formato String).
     * @return true se o e-mail for válido, false caso contrário.
     */
    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return PADRAO_EMAIL_VALIDO.matcher(email).matches();
    }
}