package com.example.demo.Validator;


import com.example.demo.Models.Medicos;
import com.example.demo.Models.Pacientes;

public class MedicosValidator {
    public static boolean isValidMedico(Medicos medico){
        if (medico == null){
            return false;
        }
        return true;
    }
}
