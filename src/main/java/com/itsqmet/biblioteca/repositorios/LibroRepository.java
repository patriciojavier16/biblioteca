package com.itsqmet.biblioteca.repositorios;

import com.itsqmet.biblioteca.entidades.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libros, Integer> {
}
