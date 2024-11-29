package com.ashislaha.springboot.cruddemo.rest;

public class EmployeeNotFoundException extends RuntimeException {
    /// constructor
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
