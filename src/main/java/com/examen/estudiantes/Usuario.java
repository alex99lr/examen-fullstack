package com.examen.estudiantes;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String password;
}