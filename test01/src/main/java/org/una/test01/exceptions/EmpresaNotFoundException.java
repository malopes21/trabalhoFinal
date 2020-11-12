package org.una.test01.exceptions;

public class EmpresaNotFoundException extends RuntimeException {
    public EmpresaNotFoundException(String message) {
        super(message);
    }
}
