package com.itsqmet.biblioteca.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity

public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaRetorno;
    private String nomPrestatario;
}
