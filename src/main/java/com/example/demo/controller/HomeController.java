package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // You can add model attributes if needed
        return "index"; // This corresponds to "index.html" in the templates directory
    }
}

//testando workflow do github...