package com.example.employeerestcrudexample.service;

import com.example.employeerestcrudexample.model.entity.Employee;
import com.example.employeerestcrudexample.model.error.EmployeeNotFoundException;
import com.example.employeerestcrudexample.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // Define fields for constructor injection
    private final EmployeeRepository employeeRepository;

    // Constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Define method for retrieving all the employees
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    // Define method for retrieving a single employee by the employee id
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + " not found!"));
    }

    // Define method for creating a new employee
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    // Define method for updating an employee by id
    public Employee updateEmployee(Long id, Employee employee) {
        Employee employeeById = this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + " not found!"));

        employeeById
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setEmail(employee.getEmail());

        return this.employeeRepository.save(employeeById);
    }

    // Define method for deleting an employee by the employee id
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
