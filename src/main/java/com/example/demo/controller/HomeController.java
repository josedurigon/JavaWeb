package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.Models.Pacientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String processForm(Model model) {
        model.addAttribute("pacientes", new Pacientes());
        // Redirect to a success page or return a response
        return "index";
    }

    @PostMapping("/register")
    public String registerPaciente(@ModelAttribute Pacientes paciente){
        System.out.println("Received Pacientes object: " + paciente.getNome());

        return "index";
    }

}

