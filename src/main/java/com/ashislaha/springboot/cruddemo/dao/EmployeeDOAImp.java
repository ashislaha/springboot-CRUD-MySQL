package com.ashislaha.springboot.cruddemo.dao;

import com.ashislaha.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDOAImp implements EmployeeDOA {

    private EntityManager entityManager;

    ///  Constructor
    @Autowired
    public EmployeeDOAImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /// Read
    @Override
    public List<Employee> findAll() {
        // All the SQL queries are based on Entity defined in POJO, not the actual entity defined in DB.
        // example - POJO Entity class `Employee`, not real DB table name `employee`.
        TypedQuery<Employee> query = entityManager.createQuery("SELECT s FROM Employee s ORDER BY s.firstName", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new RuntimeException("Employee didn't find out with employeeId: " + id);
        }
        return employee;
    }

    /// Create + Update
    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    /// Delete
    @Override
    public void deleteById(Integer id) {
        Employee emp = findById(id);
        if (emp != null) {
            entityManager.remove(emp);
        }
    }
}
