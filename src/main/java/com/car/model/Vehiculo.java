package com.car.model;

import jakarta.persistence.*;

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

    public enum TipoVehiculo { CAMION, FURGON, CISTERNA, REFRIGERADO, PLATAFORMA }

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "tipo_carga_id")
    private TipoCarga tipoCargaCompatible;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public Double getCapacidadToneladasMax() { return capacidadToneladasMax; }
    public void setCapacidadToneladasMax(Double capacidadToneladasMax) { this.capacidadToneladasMax = capacidadToneladasMax; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public TipoVehiculo getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }
    public TipoCarga getTipoCargaCompatible() { return tipoCargaCompatible; }
    public void setTipoCargaCompatible(TipoCarga tipoCargaCompatible) { this.tipoCargaCompatible = tipoCargaCompatible; }
}