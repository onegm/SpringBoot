package com.employee.EmployeeApplication.repository;

import com.employee.EmployeeApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Data access layer that uses JPA.
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Create Retrieve Update Delete
    // All CRUD methods included in the extended JpaRepository class.
    // Employee is the class or "entity" stored in this table.
    // Integer is the type of the primary key. Must be class not primitive.

}
