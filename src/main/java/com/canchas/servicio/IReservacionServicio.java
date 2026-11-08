package com.canchas.servicio;

import com.canchas.entidad.Reservacion;
import java.util.List;
import java.util.Optional;

public interface IReservacionServicio {
    Reservacion guardar(Reservacion entidad);
    List<Reservacion> listar();
    Optional<Reservacion> buscarPorId(Long id);
    Reservacion actualizar(Long id, Reservacion datos);
    void eliminar(Long id);
}
