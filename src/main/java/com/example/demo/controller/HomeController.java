package com.example.demo.controller;

import com.example.demo.Client;
import com.example.demo.Models.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class HomeController {
    private final Client client;  // <-- Private final field for Client
    @Autowired  // Add this annotation
    public HomeController(Client client) {
        this.client = client;
    }
    @GetMapping("/")
    public String processForm(Model model) {
        model.addAttribute("pacientes", new Pacientes());
        // Redirect to a success page or return a response
        return "index";
    }

    @PostMapping("/register")
    public String registerPaciente(@ModelAttribute Pacientes paciente){
        System.out.println("Received Pacientes object: " + paciente.getNome());
        client.sendObject(paciente);
        return "index";
    }

}

