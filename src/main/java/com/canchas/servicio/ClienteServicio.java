package com.canchas.servicio;

import com.canchas.entidad.Cliente;
import com.canchas.repositorio.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio {

    private final ClienteRepository repositorio;

    public ClienteServicio(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Cliente guardar(Cliente entidad) {
        return repositorio.save(entidad);
    }

    @Override
    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Cliente actualizar(Long id, Cliente datos) {
        Cliente existente = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + id));
        existente.setNombre(datos.getNombre());
        existente.setApellido(datos.getApellido());
        existente.setTelefono(datos.getTelefono());
        return repositorio.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
