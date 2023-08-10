package com.example.employeemvccrudexample.web;

import com.example.employeemvccrudexample.model.dto.AddEmployeeDto;
import com.example.employeemvccrudexample.model.dto.UpdateEmployeeDto;
import com.example.employeemvccrudexample.model.entity.Employee;
import com.example.employeemvccrudexample.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("addEmployeeDto")
    public AddEmployeeDto initAddEmployeeDto() {
        return new AddEmployeeDto();
    }

    @ModelAttribute("updateEmployeeDto")
    public UpdateEmployeeDto initUpdateEmployeeDto() {
        return new UpdateEmployeeDto();
    }

    @GetMapping("")
    public String employees(Model model) {
        model.addAttribute("employees", this.employeeService.getAllEmployeesOrderedByLastName());
        return "employees";
    }

    @GetMapping("/add")
    public String addEmployee() {
        return "employees-add";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid AddEmployeeDto addEmployeeDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeDto", addEmployeeDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);

            return "redirect:/employees/add";
        }

        this.employeeService.addEmployee(addEmployeeDto);

        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, Model model) {
        Employee employee = this.employeeService.getEmployeeById(id);

        model.addAttribute(employee);

        return "employees-update";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid UpdateEmployeeDto updateEmployeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("updateEmployeeDto", updateEmployeeDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateEmployeeDto", bindingResult);

            return "redirect:/employees/update/" + id;
        }

        this.employeeService.updateEmployee(id, updateEmployeeDto);

        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        this.employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
