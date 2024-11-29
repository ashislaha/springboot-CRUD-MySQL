package com.ashislaha.springboot.cruddemo.dao;

import com.ashislaha.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDOA {

    /// Create
    void insert(Employee employee);

    /// Read - Find list of employees
    List<Employee> findAll();

    /// Read - find a particular Employee with its ID
    Employee findById(Integer id);

    /// Update + Create - Update an employee record if present, otherwise insert it
    Employee update(Employee employee);

    /// Delete - delete a record by Id if present, otherwise no-operation
    void deleteById(Integer id);
}