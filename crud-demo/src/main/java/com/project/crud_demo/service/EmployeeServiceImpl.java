package com.project.crud_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.crud_demo.dao.EmployeeDAO;
import com.project.crud_demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
