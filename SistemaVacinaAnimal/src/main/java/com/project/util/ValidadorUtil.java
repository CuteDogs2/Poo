package com.project.util;


import java.util.regex.Pattern;
import com.project.exception.ValidationException;
/**
 * Classe utilitaria para validação de dados.
 */
public class ValidadorUtil {




    //Métodos validadores de dados
    public static void validarCampoObrigatorio(String texto, String nomeDoCampo) throws ValidationException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new ValidationException("O campo '" + nomeDoCampo + "' é obrigatório.");
        }
    }



    /**
     * Função para validação de CPF's.
     * 
     * @param cpf CPF a ser validado (no formato String).
     * @return true se o CPF for válido. false caso contrário.
     */
    public void validarCpf(String cpf) throws ValidationException {
         if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new ValidationException("O CPF deve conter exatamente 11 dígitos numéricos.");
        }

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
    public static void validarEmail(String email) throws ValidationException {
        if (email == null || email.isEmpty() || !PADRAO_EMAIL_VALIDO.matcher(email).matches()) {
            throw new ValidationException("O formato do e-mail é inválido.");
        }
    }
}