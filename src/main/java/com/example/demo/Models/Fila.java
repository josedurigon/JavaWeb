package com.example.demo.Models;


import lombok.Data;

import java.util.Date;

@Data
public class Fila {
    private int Posicao;
    private String Patient_Id;
    private String Status;
    private Date AdmissionDateTime;
    private String Nome;

}
