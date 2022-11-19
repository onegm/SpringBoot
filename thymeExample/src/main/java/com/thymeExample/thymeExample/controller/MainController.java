package com.thymeExample.thymeExample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/home")
    public String loadHome(Model model){
        model.addAttribute("name", "ThymeLeaf"); // name variable with value ThymeLeaf
        return "home"; // triggers search for "home.html" in the templates folder
    }

    @GetMapping("/elvis") // to explain 3 types of conditional statements
    public String elvisExample(Model model){
        model.addAttribute("isAdmin", true); // isAdmin variable
        model.addAttribute("gender", "M"); // gender variable
        return "elvis"; // HTML template
    }

    @GetMapping("/each") // to explain iterations in thymeleaf
    public String eachExample(Model model){
        List<String> stringList = List.of("First", "Second", "Third");
        model.addAttribute("list", stringList);
        return "each"; // HTML
    }
}
