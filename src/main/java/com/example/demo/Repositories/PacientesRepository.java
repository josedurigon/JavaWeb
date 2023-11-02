package com.example.demo.Repositories;
import com.example.demo.Models.Pacientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacientesRepository extends MongoRepository<Pacientes, Long> {
    // Define custom query methods here if needed
    Pacientes save(Pacientes pacientes);
}
