package com.example.springmvcvalidation.web;

import com.example.springmvcvalidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ModelAttribute("customer")
    public Customer initCustomer() {
        return new Customer();
    }

    @GetMapping("/customer-form")
    public String customerForm() {
        return "customer-form";
    }

    @PostMapping("/customer-form")
    public String customerForm(@Valid Customer customer,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("customer", customer);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customer", bindingResult);

            return "redirect:/customer-form";
        }

        return "success";
    }

    @GetMapping("/success")
    public String success(Model model) {
        return "success";
    }
}
