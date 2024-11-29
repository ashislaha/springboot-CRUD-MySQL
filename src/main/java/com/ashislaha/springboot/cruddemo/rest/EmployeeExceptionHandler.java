package com.ashislaha.springboot.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    ///  Error handling for "StudentNotFoundException"
    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundResponse> handleException(EmployeeNotFoundException exc) {
        EmployeeNotFoundResponse error = new EmployeeNotFoundResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /// Generic exceptional handler - catch all
    @ExceptionHandler
    public ResponseEntity<EmployeeNotFoundResponse> handleException(Exception exc) {
        EmployeeNotFoundResponse error = new EmployeeNotFoundResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
