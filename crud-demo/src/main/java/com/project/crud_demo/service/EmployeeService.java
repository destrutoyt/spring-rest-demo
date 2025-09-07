package com.project.crud_demo.service;

import java.util.List;

import com.project.crud_demo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
}
