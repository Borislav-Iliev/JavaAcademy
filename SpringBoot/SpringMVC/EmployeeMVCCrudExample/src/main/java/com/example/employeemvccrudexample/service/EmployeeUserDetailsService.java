package com.example.employeemvccrudexample.service;

import com.example.employeemvccrudexample.model.entity.Employee;
import com.example.employeemvccrudexample.model.entity.Role;
import com.example.employeemvccrudexample.model.user.EmployeeUserDetails;
import com.example.employeemvccrudexample.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class EmployeeUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.employeeRepository
                .findByEmail(username)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + "not found!"));
    }

    private UserDetails mapToUserDetails(Employee employee) {
        return new EmployeeUserDetails(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getRoles()
                        .stream()
                        .map(this::mapToGrantedAuthority)
                        .toList()
        );
    }

    private GrantedAuthority mapToGrantedAuthority(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRole().name());
    }
}
