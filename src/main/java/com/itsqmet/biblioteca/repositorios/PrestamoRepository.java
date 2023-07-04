package com.itsqmet.biblioteca.repositorios;

import com.itsqmet.biblioteca.entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {
}
