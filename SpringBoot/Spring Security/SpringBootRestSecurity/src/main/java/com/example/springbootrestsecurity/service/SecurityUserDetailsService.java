package com.example.springbootrestsecurity.service;

import com.example.springbootrestsecurity.model.entity.Employee;
import com.example.springbootrestsecurity.model.entity.Role;
import com.example.springbootrestsecurity.model.user.SecurityUserDetails;
import com.example.springbootrestsecurity.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public SecurityUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.employeeRepository
                .findByEmail(username)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found!"));
    }

    private UserDetails mapToUserDetails(Employee employee) {
        return new SecurityUserDetails(
                employee.getFirstName(),
                employee.getLastName(),
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
