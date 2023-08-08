package com.example.thymeleafexample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class ExampleController {

    @GetMapping("/date")
    public String displayDate(Model model) {

        model.addAttribute("date", LocalDate.now());

        return "date";
    }
}
