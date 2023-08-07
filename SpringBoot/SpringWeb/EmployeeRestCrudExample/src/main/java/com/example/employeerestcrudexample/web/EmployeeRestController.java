package com.example.employeerestcrudexample.web;

import com.example.employeerestcrudexample.model.entity.Employee;
import com.example.employeerestcrudexample.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Define fields for constructor injection
    private final EmployeeService employeeService;

    // Constructor injection
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Define GET mapping request for retrieving all the employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity
                .ok(this.employeeService.getAllEmployees());
    }

    // Define GET mapping request for retrieving a single employee by the employee id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity
                .ok(this.employeeService.getEmployeeById(id));
    }

    // Define POST mapping request for creating a new employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = this.employeeService.addEmployee(employee);

        return ResponseEntity
                .created(URI.create("/api/employees/" + employee.getId()))
                .body(newEmployee);
    }

    // Define PUT mapping request for updating an employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = this.employeeService
                .updateEmployee(id, employee);

        return ResponseEntity.
                ok(updatedEmployee);
    }

    // Define DELETE mapping request for deleting an employee by the employee id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = this.employeeService.getEmployeeById(id);

        this.employeeService.deleteById(id);

        return ResponseEntity.ok(deletedEmployee);
    }
}
