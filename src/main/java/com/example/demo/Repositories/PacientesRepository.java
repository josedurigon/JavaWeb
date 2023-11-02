package com.example.demo.Repositories;
import com.example.demo.Models.Pacientes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PacientesRepository extends MongoRepository<Pacientes, Long> {
    // Define custom query methods here if needed

    List<Pacientes> findByNome(String nome);

    List<Pacientes> findById(String Id);
    Pacientes save(Pacientes pacientes);
}
