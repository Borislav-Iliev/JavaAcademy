package com.example.employeemvccrudexample.service;

import com.example.employeemvccrudexample.model.dto.AddEmployeeDto;
import com.example.employeemvccrudexample.model.dto.EmployeeDto;
import com.example.employeemvccrudexample.model.dto.UpdateEmployeeDto;
import com.example.employeemvccrudexample.model.entity.Employee;
import com.example.employeemvccrudexample.model.entity.Role;
import com.example.employeemvccrudexample.model.enums.RoleEnum;
import com.example.employeemvccrudexample.model.error.EmployeeNotFoundException;
import com.example.employeemvccrudexample.model.user.EmployeeUserDetails;
import com.example.employeemvccrudexample.repository.EmployeeRepository;
import com.example.employeemvccrudexample.repository.RoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private ModelMapper modelMapper;

//    @BeforeEach
//    void setUp() {
//        this.employeeService = new EmployeeService(this.employeeRepository, this.passwordEncoder,
//                this.roleRepository, this.userDetailsService, this.modelMapper);
//    }

    @AfterEach
    void tearDown() {
        reset(this.employeeRepository);
        reset(this.roleRepository);
        reset(this.modelMapper);
        reset(this.userDetailsService);
        reset(this.passwordEncoder);
    }

    @Test
    void testRegisterAndLogin_ShouldRegisterAndLoginEmployee() {
        Employee employee = initEmployee();
        AddEmployeeDto addEmployeeDto = initAddEmployeeDto();

        when(this.modelMapper.map(addEmployeeDto, Employee.class))
                .thenReturn(employee);

        Role role = initRole();
        when(this.roleRepository.findByRole(RoleEnum.EMPLOYEE))
                .thenReturn(role);

        when(this.employeeRepository.save(employee))
                .thenReturn(employee);

        UserDetails userDetails = initUserDetails(employee);
        when(this.userDetailsService.loadUserByUsername(employee.getEmail()))
                .thenReturn(userDetails);

        this.employeeService.registerAndLogin(addEmployeeDto);
    }

    @Test
    void testGetAllEmployees_ShouldReturnAListOfEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(initEmployee());
        employees.add(initManager());

        when(this.employeeRepository.findAll())
                .thenReturn(employees);

        List<Employee> allEmployees = this.employeeService.getAllEmployees();

        assertIterableEquals(employees, allEmployees);
    }

    @Test
    void testGetAllEmployeesOrderedByLastName_ShouldReturnAListOfEmployeesDto() {
        List<EmployeeDto> employees = new ArrayList<>();
        employees.add(initEmployeeDto());
        employees.add(initManagerDto());

        when(this.employeeRepository.getAllEmployeesOrderByLastName())
                .thenReturn(employees);

        List<EmployeeDto> allEmployees = this.employeeService.getAllEmployeesOrderedByLastName();

        assertIterableEquals(employees, allEmployees);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testGetEmployeeById_ShouldReturnCorrectEmployee_WhenCorrectIdIsPassed(Long id) {
        Employee employee = initEmployee();

        when(this.employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        Employee employeeById = this.employeeService.getEmployeeById(id);

        assertEquals(employee.getId(), employeeById.getId());
        assertEquals(employee.getFirstName(), employeeById.getFirstName());
        assertEquals(employee.getLastName(), employeeById.getLastName());
        assertEquals(employee.getEmail(), employeeById.getEmail());
        assertEquals(employee.getPassword(), employeeById.getPassword());
        assertArrayEquals(employee.getRoles().toArray(new Role[0]), employeeById.getRoles().toArray(new Role[0]));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "-2", "-3", "-4"})
    void testGetEmployeeById_ShouldThrowException_WhenIncorrectEmployeeIdIsPassed(Long id) {
        when(this.employeeRepository.findById(id))
                .thenThrow(EmployeeNotFoundException.class);

        Executable employeeById = () -> this.employeeService.getEmployeeById(id);

        assertThrows(EmployeeNotFoundException.class, employeeById);
    }

    @Test
    void testAddEmployee_ShouldAddAnewEmployee() {
        Employee newEmployee = initEmployee();
        when(this.employeeRepository.save(any(Employee.class)))
                .thenReturn(newEmployee);
        when(this.employeeRepository.count())
                .thenReturn(1L);

        Role role = initRole();
        when(this.roleRepository.findByRole(RoleEnum.EMPLOYEE))
                .thenReturn(role);

        AddEmployeeDto addEmployeeDto = initAddEmployeeDto();
        when(this.modelMapper.map(addEmployeeDto, Employee.class))
                .thenReturn(newEmployee);

        Employee employee = this.employeeService.addEmployee(addEmployeeDto);

        assertEquals(newEmployee.getId(), employee.getId());
        assertEquals(newEmployee.getFirstName(), employee.getFirstName());
        assertEquals(newEmployee.getLastName(), employee.getLastName());
        assertEquals(newEmployee.getEmail(), employee.getEmail());
        assertEquals(newEmployee.getPassword(), employee.getPassword());
        assertArrayEquals(employee.getRoles().toArray(new Role[0]), employee.getRoles().toArray(new Role[0]));
        assertEquals(1, this.employeeRepository.count());
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testUpdateEmployee_ShouldUpdateEmployee_WhenCorrectEmployee(Long id) {
        Employee employee = initEmployee();

        when(this.employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        when(this.employeeRepository.save(employee))
                .thenReturn(employee);

        UpdateEmployeeDto updateEmployeeDto = new UpdateEmployeeDto()
                .setFirstName("FirstName").setLastName("LastName").setEmail("email@example.com");

        Employee updatedEmployee = this.employeeService.updateEmployee(id, updateEmployeeDto);

        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        assertEquals(employee.getLastName(), updatedEmployee.getLastName());
        assertEquals(employee.getEmail(), updatedEmployee.getEmail());
    }

    @ParameterizedTest
    @CsvSource(value = {"1, F, L, E", "2, f, l, e", "3, a, a, a", "4, b, b, b"})
    void testUpdateEmployee_ShouldSkipEmployeeField_WhenIncorrectEmployeeDataIsPassed(
            Long id,
            String firstName,
            String lastName,
            String email
    ) {
        Employee employee = initEmployee();

        when(this.employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        when(this.employeeRepository.save(employee))
                .thenReturn(employee);

        UpdateEmployeeDto updateEmployeeDto = new UpdateEmployeeDto()
                .setFirstName(firstName).setLastName(lastName).setEmail(email);

        Employee updatedEmployee = this.employeeService.updateEmployee(id, updateEmployeeDto);

        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        assertEquals(employee.getLastName(), updatedEmployee.getLastName());
        assertEquals(employee.getEmail(), updatedEmployee.getEmail());
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "-2", "-3", "-4"})
    void testUpdateEmployee_ShouldThrowException_WhenIncorrectEmployeeId(Long id) {
        UpdateEmployeeDto updateEmployeeDto = new UpdateEmployeeDto()
                .setFirstName("").setLastName("").setEmail("email@example.com");

        Executable updatedEmployee = () -> this.employeeService.updateEmployee(id, updateEmployeeDto);

        assertThrows(EmployeeNotFoundException.class, updatedEmployee);
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4"})
    void testDeleteEmployee_ShouldDeleteEmployee(Long id) {
        this.employeeService.deleteById(id);

        verify(this.employeeRepository, times(1)).deleteById(id);
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

    private Employee initManager() {
        Employee employee = new Employee();
        employee
                .setId(1L)
                .setFirstName("First Manger")
                .setLastName("Last Manager")
                .setEmail("emailManager@example.com")
                .setPassword("1234")
                .setRoles(List.of(new Role(RoleEnum.EMPLOYEE).setId(1L), new Role(RoleEnum.MANAGER).setId(2L)));

        return employee;
    }

    private EmployeeDto initEmployeeDto() {
        EmployeeDto employee = new EmployeeDto();
        employee
                .setId(1L)
                .setFirstName("First")
                .setLastName("Last")
                .setEmail("email@example.com");

        return employee;
    }

    private EmployeeDto initManagerDto() {
        EmployeeDto employee = new EmployeeDto();
        employee
                .setId(1L)
                .setFirstName("First Manger")
                .setLastName("Last Manager")
                .setEmail("emailManager@example.com");

        return employee;
    }

    private AddEmployeeDto initAddEmployeeDto() {
        AddEmployeeDto employee = new AddEmployeeDto();
        employee
                .setFirstName("First")
                .setLastName("Last")
                .setEmail("emailDto@example.com")
                .setPassword("1234")
                .setConfirmPassword("1234");

        return employee;
    }

    private Role initRole() {
        return new Role(RoleEnum.EMPLOYEE);
    }

    private UserDetails initUserDetails(Employee employee) {
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
