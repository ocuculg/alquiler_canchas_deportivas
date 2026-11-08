package com.canchas.repositorio;

import com.canchas.entidad.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}
