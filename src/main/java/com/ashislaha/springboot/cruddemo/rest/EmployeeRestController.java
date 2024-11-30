package com.ashislaha.springboot.cruddemo.rest;

import com.ashislaha.springboot.cruddemo.dao.EmployeeDOA;
import com.ashislaha.springboot.cruddemo.entity.Employee;
import com.ashislaha.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    /// constructor
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /// Read employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
       return employeeService.findById(employeeId);
    }

    /// Create a new employee, we use the same api with post body
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        // if we got id in the request body, set id to 0 so that it will create a new object
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    /// Update an existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    /// Delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
    }
}