package com.canchas.servicio;

import com.canchas.entidad.Cancha;
import com.canchas.repositorio.CanchaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CanchaServicio implements ICanchaServicio {

    private final CanchaRepository repositorio;

    public CanchaServicio(CanchaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Cancha guardar(Cancha entidad) {
        return repositorio.save(entidad);
    }

    @Override
    public List<Cancha> listar() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Cancha> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Cancha actualizar(Long id, Cancha datos) {
        Cancha existente = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrado: " + id));
        existente.setNombre(datos.getNombre());
        existente.setTipo(datos.getTipo());
        existente.setPrecioHora(datos.getPrecioHora());
        existente.setDisponible(datos.getDisponible());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
