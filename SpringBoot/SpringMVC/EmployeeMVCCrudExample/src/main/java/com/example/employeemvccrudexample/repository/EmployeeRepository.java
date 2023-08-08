package com.example.employeemvccrudexample.repository;

import com.example.employeemvccrudexample.model.dto.EmployeeDto;
import com.example.employeemvccrudexample.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.employeemvccrudexample.model.dto.EmployeeDto" +
            " (e.id, e.firstName, e.lastName, e.email)" +
            " FROM Employee e" +
            " ORDER BY e.lastName")
    List<EmployeeDto> getAllEmployeesOrderByLastName();

    Optional<Employee> findByEmail(String email);
}
