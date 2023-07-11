package com.itsqmet.biblioteca.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "El campo nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El campo autor es obligatorio")
    @Column(nullable = false)
    private String autor;

    @NotBlank(message = "El campo editorial es obligatorio")
    @Column(nullable = false)
    private String editorial;

    @NotBlank(message = "El campo edición es obligatorio")
    @Column(nullable = false)
    private String edicion;

    @NotBlank(message = "El campo categoria es obligatorio")
    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private Integer numeroCopias;

}
