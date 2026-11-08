package com.canchas.servicio;

import com.canchas.entidad.Cancha;
import java.util.List;
import java.util.Optional;

public interface ICanchaServicio {
    Cancha guardar(Cancha entidad);
    List<Cancha> listar();
    Optional<Cancha> buscarPorId(Long id);
    Cancha actualizar(Long id, Cancha datos);
    void eliminar(Long id);
}
