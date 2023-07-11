package com.itsqmet.biblioteca.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Afiliado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El campo apellido es obligatorio")
    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer edad;

    @NotBlank(message = "El campo direccion es obligatorio")
    @Column(nullable = false)
    private String direccion;

    @NotBlank(message = "El campo telefono es obligatorio")
    @Column(nullable = false)
    private String telefono;

    @NotBlank(message = "El campo correo es obligatorio")
    @Column(nullable = false)
    private String correo;


}
