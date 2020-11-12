package org.una.test01.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
    public EnderecoNotFoundException(String message) {
        super(message);
    }
}
