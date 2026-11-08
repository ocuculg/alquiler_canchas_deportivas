package com.canchas.entidad;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancha;
    private String nombre;
    private String tipo;
    private BigDecimal precioHora;
    private Boolean disponible;
}
