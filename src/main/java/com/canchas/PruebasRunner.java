package com.canchas;

import com.canchas.entidad.*;
import com.canchas.servicio.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class PruebasRunner implements CommandLineRunner {

    private final IClienteServicio clienteServicio;
    private final ICanchaServicio canchaServicio;
    private final IReservacionServicio reservacionServicio;

    public PruebasRunner(IClienteServicio c, ICanchaServicio ca, IReservacionServicio r) {
        this.clienteServicio = c;
        this.canchaServicio = ca;
        this.reservacionServicio = r;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n===== 1. Registrar 2 clientes y 2 canchas =====");
        Cliente c1 = clienteServicio.guardar(new Cliente(null, "Oscar", "Cucul", "5555-1111"));
        Cliente c2 = clienteServicio.guardar(new Cliente(null, "Ana", "López", "5555-2222"));
        Cancha ca1 = canchaServicio.guardar(new Cancha(null, "Cancha 1", "Fútbol 5", new BigDecimal("150.00"), true));
        Cancha ca2 = canchaServicio.guardar(new Cancha(null, "Cancha 2", "Baloncesto", new BigDecimal("100.00"), true));
        System.out.println("Registrados: " + c1 + " | " + c2 + " | " + ca1 + " | " + ca2);

        System.out.println("\n===== 2. Registrar 2 reservaciones =====");
        Reservacion r1 = reservacionServicio.guardar(
                new Reservacion(null, c1.getIdCliente(), ca1.getIdCancha(), LocalDate.now().plusDays(1), 2));
        Reservacion r2 = reservacionServicio.guardar(
                new Reservacion(null, c2.getIdCliente(), ca2.getIdCancha(), LocalDate.now().plusDays(2), 1));
        System.out.println("Registradas: " + r1 + " | " + r2);

        System.out.println("\n===== 3. Listar clientes, canchas y reservaciones =====");
        System.out.println("-- Clientes --");
        clienteServicio.listar().forEach(System.out::println);
        System.out.println("-- Canchas --");
        canchaServicio.listar().forEach(System.out::println);
        System.out.println("-- Reservaciones --");
        reservacionServicio.listar().forEach(System.out::println);

        System.out.println("\n===== 4. Buscar una cancha por ID =====");
        canchaServicio.buscarPorId(ca1.getIdCancha())
                .ifPresentOrElse(c -> System.out.println("Encontrada: " + c),
                        () -> System.out.println("No existe la cancha"));

        System.out.println("\n===== 5. Actualizar precio de una cancha =====");
        System.out.println("Antes:   " + canchaServicio.buscarPorId(ca1.getIdCancha()).get());
        Cancha cambios = new Cancha(null, ca1.getNombre(), ca1.getTipo(), new BigDecimal("200.00"), ca1.getDisponible());
        canchaServicio.actualizar(ca1.getIdCancha(), cambios);
        System.out.println("Después: " + canchaServicio.buscarPorId(ca1.getIdCancha()).get());

        System.out.println("\n===== 6. Eliminar una reservación y mostrar listado =====");
        reservacionServicio.eliminar(r2.getIdReservacion());
        reservacionServicio.listar().forEach(System.out::println);
    }
}
