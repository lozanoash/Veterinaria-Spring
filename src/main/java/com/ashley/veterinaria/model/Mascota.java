package com.ashley.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Mascota {
    @Id
    private int id;
    private String nombre;
    private int edad;
    private String especie;
    private String duenio;

}
