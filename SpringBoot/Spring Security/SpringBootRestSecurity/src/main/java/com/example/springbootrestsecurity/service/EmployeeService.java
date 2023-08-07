package com.example.springbootrestsecurity.service;

import com.example.springbootrestsecurity.model.entity.Employee;
import com.example.springbootrestsecurity.model.entity.Role;
import com.example.springbootrestsecurity.model.enums.RoleEnum;
import com.example.springbootrestsecurity.model.error.EmployeeNotFoundException;
import com.example.springbootrestsecurity.repository.EmployeeRepository;
import com.example.springbootrestsecurity.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    // Define fields for constructor injection
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    // Constructor injection
    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
        employee.setPassword(this.passwordEncoder.encode(employee.getPassword()));

        Role role = this.roleRepository.findByRole(RoleEnum.EMPLOYEE);

        employee.setRoles(List.of(role));

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
