package com.project.crud_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.crud_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
