package com.example.demo.Models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection="Fila")
public class Fila implements Serializable {
    private int Posicao;
    private String Patient_Id;
    private String Status;
    private LocalDateTime AdmissionDateTime;
    private String Nome;

}
