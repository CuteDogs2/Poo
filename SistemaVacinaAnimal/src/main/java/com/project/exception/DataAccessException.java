
package com.project.exception;


public class DataAccessException extends Exception {

    /**
     * Construtor para erros de acesso a dados.
     *
     * @param message Uma mensagem clara para o desenvolvedor sobre o que falhou.
     * @param cause   A exceção original (geralmente uma SQLException) que causou o problema.
     * Isso é importante para não perder a causa raiz do erro durante a depuração.
     */
    public DataAccessException(String message, Throwable cause) {
       
        super(message, cause);
    }
}