package com.car.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cargas")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String descripcionEnvio;

    @Column(nullable = false)
    private Double pesoKg;

    @Column(nullable = false)
    private Double precioFlete;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCarga estado;

    public enum EstadoCarga {
        PENDIENTE, EN_TRANSITO, ENTREGADO, CANCELADO
    }

    @ManyToOne
    @JoinColumn(name = "tipo_carga_id", nullable = false)
    private TipoCarga tipoCarga;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}