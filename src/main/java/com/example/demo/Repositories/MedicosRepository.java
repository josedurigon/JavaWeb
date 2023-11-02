package com.example.demo.Repositories;

import com.example.demo.Models.Medicos;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MedicosRepository extends MongoRepository<Medicos, Long> {
    List<Medicos> findByNome(String name);
    List<Medicos> findAll();

//    List<Medicos> finByEspecialidade();

    Medicos save (Medicos medico);


}
