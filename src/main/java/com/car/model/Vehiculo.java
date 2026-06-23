package com.car.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 20)
    private String placa;

    @Column(nullable = false)
    private Double capacidadToneladasMax;

    @Column(length = 255)
    private String fotoUrl;

    @Column(length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVehiculo tipoVehiculo;

    public enum TipoVehiculo {
        CAMION, FURGON, CISTERNA, REFRIGERADO, PLATAFORMA
    }

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "tipo_carga_id")
    private TipoCarga tipoCargaCompatible;
}