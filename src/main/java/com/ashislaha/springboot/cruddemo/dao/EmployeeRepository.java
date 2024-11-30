package com.ashislaha.springboot.cruddemo.dao;

import com.ashislaha.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // It has all the CRUD operations
}
