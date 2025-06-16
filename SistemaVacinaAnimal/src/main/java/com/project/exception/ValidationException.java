package com.project.exception;

//Para erros de validação de dados inseridos pelo usuário.

public class ValidationException extends Exception {



    /**
     * Construtor que aceita uma mensagem de erro detalhada.
     *
     * @param message A mensagem que descreve o erro de validação.
     * Esta mensagem será exibida para o usuário.
     */
    


    public ValidationException(String message) {
        // A palavra-chave 'super(message)' passa a mensagem de erro para o construtor
        // da classe pai (Exception).
        super(message);
    }
}