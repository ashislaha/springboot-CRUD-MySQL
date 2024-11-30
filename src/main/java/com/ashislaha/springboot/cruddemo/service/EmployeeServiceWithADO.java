package com.ashislaha.springboot.cruddemo.service;

import com.ashislaha.springboot.cruddemo.dao.EmployeeDOA;
import com.ashislaha.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service
public class EmployeeServiceWithADO implements EmployeeService {

    private EmployeeDOA employeeDOA;

    @Autowired
    public EmployeeServiceWithADO(EmployeeDOA employeeDOA) {
        this.employeeDOA = employeeDOA;
    }

    /// Methods
    @Override
    public List<Employee> findAll() {
        return employeeDOA.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDOA.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDOA.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        employeeDOA.deleteById(id);
    }
}

