package com.itsqmet.biblioteca.repositorios;

import com.itsqmet.biblioteca.entidades.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {


}
