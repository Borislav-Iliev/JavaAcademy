package com.example.employeerestcrudexample.service;

import com.example.employeerestcrudexample.model.entity.Employee;
import com.example.employeerestcrudexample.model.error.EmployeeNotFoundException;
import com.example.employeerestcrudexample.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private static List<Employee> expectedEmployees;
    private static Employee employee;
    private static Employee updateEmployee;

    @BeforeAll
    static void setUp() {
        expectedEmployees = List.of(initEmployee(), initEmployee());
        employee = initEmployee();
        updateEmployee = initUpdateEmployee();
    }

    @Test
    void testGetAllEmployees_ShouldReturnCorrectListOfEmployees() {
        when(this.employeeRepository.findAll())
                .thenReturn(expectedEmployees);

        List<Employee> actualEmployees = this.employeeService.getAllEmployees();

        assertIterableEquals(expectedEmployees, actualEmployees);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testGetEmployeeById_ShouldReturnCorrectEmployee_WhenValidEmployeeIdIsPassed(Long id) {
        when(this.employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        Employee actualEmployee = this.employeeService.getEmployeeById(id);

        assertEquals(employee.getId(), actualEmployee.getId());
        assertEquals(employee.getFirstName(), actualEmployee.getFirstName());
        assertEquals(employee.getLastName(), actualEmployee.getLastName());
        assertEquals(employee.getEmail(), actualEmployee.getEmail());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "-2", "-3", "-4"})
    void testGetEmployeeById_ShouldThrowEmployeeNotFoundException_WhenInvalidEmployeeIdIsPassed(Long id) {
        Executable actualEmployee = () -> this.employeeService.getEmployeeById(id);

        assertThrows(EmployeeNotFoundException.class, actualEmployee);
    }

    @Test
    void testAddEmployee_ShouldAddEmployee() {
        this.employeeService.addEmployee(employee);

        verify(this.employeeRepository, times(1)).save(employee);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testUpdateEmployee_ShouldUpdateEmployee_WhenValidEmployeeIdIsPassed(Long id) {
        when(this.employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        when(this.employeeRepository.save(employee))
                .thenReturn(employee);

        Employee updatedEmployee = this.employeeService.updateEmployee(id, updateEmployee);

        assertEquals(employee.getId(), updatedEmployee.getId());
        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        assertEquals(employee.getLastName(), updatedEmployee.getLastName());
        assertEquals(employee.getEmail(), updatedEmployee.getEmail());
        verify(this.employeeRepository, times(1)).save(employee);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "-2", "-3", "-4"})
    void testUpdateEmployee_ShouldThrowEmployeeNotFoundException_WhenInvalidEmployeeIdIsPassed(Long id) {
        Executable updatedEmployee = () -> this.employeeService.updateEmployee(id, updateEmployee);

        assertThrows(EmployeeNotFoundException.class, updatedEmployee);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testDeleteById_ShouldDeleteEmployeeById(Long id) {
        this.employeeService.deleteById(id);

        verify(this.employeeRepository, times(1)).deleteById(id);
    }

    private static Employee initEmployee() {
        return new Employee()
                .setId(1L)
                .setFirstName("FirstName")
                .setLastName("LastName")
                .setEmail("email@example.com");
    }

    private static Employee initUpdateEmployee() {
        return new Employee()
                .setFirstName("UpdatedFirstName")
                .setLastName("UpdatedLastName")
                .setEmail("updateEmail@example.com");
    }
}
