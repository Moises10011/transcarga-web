package com.car.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

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

    public enum EstadoCarga { PENDIENTE, EN_TRANSITO, ENTREGADO, CANCELADO }

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcionEnvio() { return descripcionEnvio; }
    public void setDescripcionEnvio(String descripcionEnvio) { this.descripcionEnvio = descripcionEnvio; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getPrecioFlete() { return precioFlete; }
    public void setPrecioFlete(Double precioFlete) { this.precioFlete = precioFlete; }
    public EstadoCarga getEstado() { return estado; }
    public void setEstado(EstadoCarga estado) { this.estado = estado; }
    public TipoCarga getTipoCarga() { return tipoCarga; }
    public void setTipoCarga(TipoCarga tipoCarga) { this.tipoCarga = tipoCarga; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}