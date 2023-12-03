package com.example.demo.process;

import com.example.demo.Models.Pacientes;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

@Service
public class Process {

    @NotNull
    public Pacientes selecionarProximoFila( ArrayList<Pacientes> filaPacientes){
        Pacientes proximo = filaPacientes.get(filaPacientes.size()-1);
        return proximo;
    }
    @NotNull
    public Pacientes peekUltimo( ArrayList<Pacientes> filaPacientes){
        Pacientes ultimo = filaPacientes.get(0);
        return ultimo;
    }


    @NotNull
    public Pacientes chamarPaciente(ArrayList<Pacientes> filaPacientes){
        if(!filaPacientes.isEmpty()) {
            Pacientes proximo = this.selecionarProximoFila(filaPacientes);
            filaPacientes.remove(0);
            return proximo;
        }else{
            return null;
        }
    }

    public Duration tempoDeEspera(ArrayList<Pacientes> pacientesArrayList) {
        if (pacientesArrayList.isEmpty()) {
            return Duration.ZERO; // No patients, no waiting time
        }

//        Pacientes primeiroFila = pacientesArrayList.get(pacientesArrayList.size() - 1);
//        Pacientes ultimo = pacientesArrayList.get(0);

        // Assuming each consultation takes 10 minutes
        long totalMinutes = pacientesArrayList.size() * 10L;
        Duration waitingTime = Duration.ofMinutes(totalMinutes);

        return waitingTime;
    }

    public int posicaoNaFila(ArrayList<Pacientes> pacientesArrayList){
        return pacientesArrayList.size()-1;
    }

    @NotNull
    public static ArrayList<Pacientes> pacientesProcess(ArrayList<Document> arrayList){
        ArrayList<Pacientes> filaPacientes = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            Pacientes pacientes = new Pacientes();
            pacientes.setId(arrayList.get(i).get("Patient_Id").toString());
            pacientes.setNome(arrayList.get(i).get("Nome").toString());
            pacientes.setAdmissao((Date) arrayList.get(i).get("AdmissionDateTime"));

            filaPacientes.add(pacientes);
        }
        return filaPacientes;
    }


}
