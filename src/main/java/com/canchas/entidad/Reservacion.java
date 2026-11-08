package com.canchas.entidad;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservacion;
    private Long idCliente;
    private Long idCancha;
    private LocalDate fecha;
    private Integer horas;
}
