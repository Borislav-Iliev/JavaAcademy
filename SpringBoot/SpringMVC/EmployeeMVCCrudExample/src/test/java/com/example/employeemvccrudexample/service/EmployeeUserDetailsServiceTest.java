package com.example.employeemvccrudexample.service;

import com.example.employeemvccrudexample.model.entity.Employee;
import com.example.employeemvccrudexample.model.entity.Role;
import com.example.employeemvccrudexample.model.enums.RoleEnum;
import com.example.employeemvccrudexample.model.user.EmployeeUserDetails;
import com.example.employeemvccrudexample.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeUserDetailsServiceTest {

    private EmployeeUserDetailsService employeeUserDetailsService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        this.employeeUserDetailsService = new EmployeeUserDetailsService(this.employeeRepository);
    }

    @Test
    void testLoadByUsernameShouldReturnCorrectEmployee() {
        Employee employee = initEmployee();

        when(this.employeeRepository.findByEmail(employee.getEmail()))
                .thenReturn(Optional.of(employee));

        EmployeeUserDetails userDetails =
                (EmployeeUserDetails) this.employeeUserDetailsService.loadUserByUsername("email@example.com");

        assertEquals(userDetails.getUsername(), employee.getEmail());
        assertEquals(userDetails.getFirstName(), employee.getFirstName());
        assertEquals(userDetails.getLastName(), employee.getLastName());
        assertEquals(userDetails.getPassword(), employee.getPassword());

        String expectedRoles = "ROLE_EMPLOYEE";
        String actualRoles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));

        assertEquals(expectedRoles, actualRoles);
    }

    @Test
    void testLoadByUsernameShouldThrowUsernameNotFoundExceptionWhenIncorrectEmployee() {
        Executable userDetails = () -> this.employeeUserDetailsService.loadUserByUsername("email@example.com");

        assertThrows(UsernameNotFoundException.class, userDetails);
    }

    private Employee initEmployee() {
        Employee employee = new Employee();
        employee
                .setId(1L)
                .setFirstName("First")
                .setLastName("Last")
                .setEmail("email@example.com")
                .setPassword("1234")
                .setRoles(List.of(new Role(RoleEnum.EMPLOYEE).setId(1L)));

        return employee;
    }
}