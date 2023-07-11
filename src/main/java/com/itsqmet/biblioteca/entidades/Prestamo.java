package com.itsqmet.biblioteca.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity

public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "El campo libro es obligatorio")
    @Column(nullable = false)
    private String libro;

    @Column(nullable = false)
    private LocalDate fechaPrestamo;
    @Column(nullable = false)
    private LocalDate fechaRetorno;
    @NotBlank(message = "El campo nomPrestatario es obligatorio")
    @Column(nullable = false)
    private String nomPrestatario;
}
