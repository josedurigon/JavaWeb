package com.example.demo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "Pacientes")
public class Pacientes implements Serializable {

    @Id
    private String id;
    private String nome;
    private String endereco;
    private String contato;
    private String historico_medico;
    private Date admissao;

}
