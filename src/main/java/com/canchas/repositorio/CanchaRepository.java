package com.canchas.repositorio;

import com.canchas.entidad.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanchaRepository extends JpaRepository<Cancha, Long> {
}
