package org.una.test01.exceptions;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String message) {
        super(message);
    }
}
