package org.una.test01.exceptions.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.una.test01.exceptions.EmpresaNotFoundException;
import org.una.test01.exceptions.EnderecoNotFoundException;
import org.una.test01.exceptions.FuncionarioNotFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EmpresaNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerEmpresaNotFoundException(EmpresaNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Empresa exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(FuncionarioNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerFuncionarioNotFoundException(FuncionarioNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Funcionario exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlerEnderecoNotFoundException(EnderecoNotFoundException e, HttpServletRequest request) {
        e.printStackTrace();
        ErrorDetails error = new ErrorDetails();
        error.setStatus(404l);
        error.setTitle("Endereço exception.");
        error.setUrl("http://erros.teste.com/404");
        error.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
