package com.example.demo.controller;

import com.example.demo.Models.Pacientes;
import com.example.demo.connection.Client;
import com.example.demo.process.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

@Controller
public class FormController {

    private final Client client;
    private final Process process;

    @Autowired
    public FormController(Client client, Process process) {
        this.client = client;
        this.process = process;
    }

    @GetMapping("/Fila")
    public String displayFila(Model model) throws IOException, ClassNotFoundException {

       ArrayList<Pacientes> fila = Client.use();
       Duration tempoEspera =  process.tempoDeEspera(fila);
       int posicao = process.posicaoNaFila(fila);
       model.addAttribute("tempoEspera", tempoEspera);
       model.addAttribute("posicaoNaFila", posicao);

       return "fila";
    }
}