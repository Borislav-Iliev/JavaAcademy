package com.example.employeemvccrudexample.service;

import com.example.employeemvccrudexample.model.dto.AddEmployeeDto;
import com.example.employeemvccrudexample.model.dto.EmployeeDto;
import com.example.employeemvccrudexample.model.entity.Employee;
import com.example.employeemvccrudexample.model.error.EmployeeNotFoundException;
import com.example.employeemvccrudexample.repository.EmployeeRepository;
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

    // Define method for retrieving all the employees dto ordered by last name in ascending order
    public List<EmployeeDto> getAllEmployeesOrderedByLastName() {
        return this.employeeRepository.getAllEmployeesOrderByLastName();
    }

    // Define method for retrieving a single employee by the employee id
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + " not found!"));
    }

    // Define method for creating a new employee
    public Employee addEmployee(AddEmployeeDto addEmployeeDto) {
        Employee employee = new Employee();

        employee
                .setFirstName(addEmployeeDto.getFirstName())
                .setLastName(addEmployeeDto.getLastName())
                .setEmail(addEmployeeDto.getEmail());

        return this.employeeRepository.save(employee);
    }

    // Define method for updating an employee by id
    public Employee updateEmployee(Long id, AddEmployeeDto addEmployeeDto) {
        Employee employee = this.employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id: " + id + " not found!"));

        employee
                .setFirstName(addEmployeeDto.getFirstName())
                .setLastName(addEmployeeDto.getLastName())
                .setEmail(addEmployeeDto.getEmail());

        return this.employeeRepository.save(employee);
    }

    // Define method for deleting an employee by the employee id
    public void deleteById(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
