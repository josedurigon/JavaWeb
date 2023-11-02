package com.example.demo.Models;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Data
@Document(collection = "Medicos")
public class Medicos {
        @Id
        private String id;
        private String nome;
        private String especialidade;
        private String endereco;
        private String contato;

}
