package com.example.demo.Medicos;


import com.example.demo.Models.Medicos;
import com.example.demo.Repositories.MedicosRepository;
import com.example.demo.Validator.MedicosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
    private MedicosRepository medicosRepository;

    @GetMapping
    public ResponseEntity<List<Medicos>> getMedicos() {
        //List<Medicos> medicosList = medicosRepository.findAll();
        List<Medicos> medicosList = medicosRepository.findAll();
        return ResponseEntity.ok(medicosList);
    }

    @PostMapping("/add")
    public ResponseEntity<Medicos> createMedico(@RequestBody Medicos medico) {
        if (MedicosValidator.isValidMedico(medico)) {
            Medicos savedMedico = medicosRepository.save(medico);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMedico);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
