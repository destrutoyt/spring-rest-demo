package com.project.crud_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.crud_demo.entity.Employee;

@RepositoryRestResource(path="members") // http://localhost:8080/members instead of http://localhost:8080/employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
