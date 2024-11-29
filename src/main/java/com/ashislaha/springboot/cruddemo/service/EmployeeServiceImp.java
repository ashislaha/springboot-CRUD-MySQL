package com.ashislaha.springboot.cruddemo.service;

import com.ashislaha.springboot.cruddemo.dao.EmployeeDOA;
import com.ashislaha.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeDOA employeeDOA;

    /// constructor
    @Autowired
    public EmployeeServiceImp(EmployeeDOA employeeDOA) {
        this.employeeDOA = employeeDOA;
    }

    /// Methods
    @Override
    @Transactional
    public void insert(Employee employee) {
        employeeDOA.insert(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDOA.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeDOA.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee didn't find out with employeeId: " + id);
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeDOA.update(employee);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeDOA.deleteById(id);
        }
    }
}
