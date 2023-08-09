package com.example.employeemvccrudexample.web;

import com.example.employeemvccrudexample.model.dto.AddEmployeeDto;
import com.example.employeemvccrudexample.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

    private final EmployeeService employeeService;

    public AuthenticationController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ModelAttribute("addEmployeeDto")
    public AddEmployeeDto initAddEmployeeDto() {
        return new AddEmployeeDto();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid AddEmployeeDto addEmployeeDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEmployeeDto", addEmployeeDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEmployeeDto", bindingResult);

            return "redirect:/auth/register";
        }

        this.employeeService.registerAndLogin(addEmployeeDto);

        return "redirect:/employees";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String loginError(@ModelAttribute("username") String username,
                             RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("username", username);
        redirectAttributes.addFlashAttribute("badCredentials", true);

        return "redirect:/auth/login";
    }
}
