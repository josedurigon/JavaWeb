package com.example.demo.Repositories;
import com.example.demo.Models.Medicos;
import com.example.demo.Models.Pacientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicosRepository extends MongoRepository<Medicos, Long> {
    // Define custom query methods here if needed
    Medicos save(Medicos medicos);

}
