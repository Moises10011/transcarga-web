package com.car.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "conductores")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 20)
    private String telefono;

    @Column(nullable = false, unique = true, length = 50)
    private String numeroLicencia;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 255)
    private String fotoUrl;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}