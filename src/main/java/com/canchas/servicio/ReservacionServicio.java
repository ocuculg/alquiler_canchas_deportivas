package com.canchas.servicio;

import com.canchas.entidad.Reservacion;
import com.canchas.repositorio.ReservacionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservacionServicio implements IReservacionServicio {

    private final ReservacionRepository repositorio;

    public ReservacionServicio(ReservacionRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Reservacion guardar(Reservacion entidad) {
        return repositorio.save(entidad);
    }

    @Override
    public List<Reservacion> listar() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Reservacion> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Reservacion actualizar(Long id, Reservacion datos) {
        Reservacion existente = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservacion no encontrado: " + id));
        existente.setIdCliente(datos.getIdCliente());
        existente.setIdCancha(datos.getIdCancha());
        existente.setFecha(datos.getFecha());
        existente.setHoras(datos.getHoras());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
