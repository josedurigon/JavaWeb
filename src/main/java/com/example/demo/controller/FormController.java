package com.example.demo.controller;

import com.example.demo.Models.Pacientes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("/Fila")
    public String home(Model model) {
        Pacientes paciente = new Pacientes();

        return "fila";
    }
}