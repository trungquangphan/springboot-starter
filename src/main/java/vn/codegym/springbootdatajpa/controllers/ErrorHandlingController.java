package vn.codegym.springbootdatajpa.controllers;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception) {
        exception.printStackTrace();
        return "general-error";
    }

    @ExceptionHandler(BindException.class)
    public String handleBindException(BindException exception) {
        exception.printStackTrace();
        return "general-error";
    }
}
