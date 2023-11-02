package com.example.demo.Pacientes;


import com.example.demo.Models.Pacientes;
import com.example.demo.Repositories.PacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    //log
    @Autowired
    private PacientesRepository pacientesRepository;


    @GetMapping // Add this annotation to map the method to HTTP GET requests
    public ResponseEntity<List<Pacientes>> getPacientes() {
        List<Pacientes> pacientesList = pacientesRepository.findAll();
        return ResponseEntity.ok(pacientesList);
    }

    @PostMapping
    public ResponseEntity<Pacientes> createPacientes(@RequestBody Pacientes pacientes){
        Pacientes createdPaciente = pacientesRepository.save(pacientes);
        return ResponseEntity.ok(createdPaciente);
    }

}
