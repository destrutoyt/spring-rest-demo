package com.project.crud_demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.crud_demo.entity.Employee;
import com.project.crud_demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    // Quick and dirty: inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    // Expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    // Expose "/employees/{employeeId}" and return employee by ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);    // In case employee is not found
        }
        return theEmployee;
    }

    // Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // Also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setID(0); // If using "Integer" instead of "int" use "null"

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")   // By using @DeleteMapping, we are mapping DELETE HTTP method
    public String deleteEmployee(@PathVariable int employeeId) { // Delete employee by ID

        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) { // Using Map to receive partial update payload (key-value pairs)

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId); // In case employee is not found
        }

        // Throw exception if request body updates contains an ID
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee ID not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, tempEmployee);

        // Save the updated employee
        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    /**
     * Convert data to JSON object nodes.
     * Merge / Apply the patch.
     * Convert JSON object node back to Employee object.
     * @param patchPayload - Map with key-value pairs to update
     * @param tempEmployee - Employee object to apply the patch to
     */
    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
        
        // Convert employee object to a JSON object node
        ObjectNode JSON_employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);

        // Convert the patchPayLoad map to a JSON object node
        ObjectNode JSON_patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        // Merge the patch updates into the employee node
        JSON_employeeNode.setAll(JSON_patchNode);

        return objectMapper.convertValue(JSON_employeeNode, Employee.class); // Convert the updated employee node back to an Employee object
    }

}
