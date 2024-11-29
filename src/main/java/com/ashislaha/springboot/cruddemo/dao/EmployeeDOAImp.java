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

    /// Create
    @Override
    public void insert(Employee employee) {
       entityManager.persist(employee);
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
        return entityManager.find(Employee.class, id);
    }

    /// Update
    @Override
    public Employee update(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    /// Delete
    @Override
    public void deleteById(Integer id) {
        Employee emp = entityManager.find(Employee.class, id);
        entityManager.remove(emp);
    }
}
