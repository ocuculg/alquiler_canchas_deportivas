package com.canchas.servicio;

import com.canchas.entidad.Cliente;
import java.util.List;
import java.util.Optional;

public interface IClienteServicio {
    Cliente guardar(Cliente entidad);
    List<Cliente> listar();
    Optional<Cliente> buscarPorId(Long id);
    Cliente actualizar(Long id, Cliente datos);
    void eliminar(Long id);
}
