package com.project.crud_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.crud_demo.dao.EmployeeRepository;
import com.project.crud_demo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee thEmployee = null;
        if (result.isPresent()) {
            thEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return thEmployee;
    }

    @Override
    // @Transactional  // Transactional is needed for save operation (or modify operation). Server manages transaction automatically.
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    // @Transactional  // Transactional is needed for delete operation. Server handles transaction automatically. JPA Repository methods are transactional by default.
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
