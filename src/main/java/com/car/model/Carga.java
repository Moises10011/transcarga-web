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

    
    @ManyToOne
    @JoinColumn(name = "tipo_carga_id", nullable = false)
    private TipoCarga tipoCarga;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Carga() {}

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcionEnvio() { return descripcionEnvio; }
    public void setDescripcionEnvio(String descripcionEnvio) { this.descripcionEnvio = descripcionEnvio; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getPrecioFlete() { return precioFlete; }
    public void setPrecioFlete(Double precioFlete) { this.precioFlete = precioFlete; }
    public TipoCarga getTipoCarga() { return tipoCarga; }
    public void setTipoCarga(TipoCarga tipoCarga) { this.tipoCarga = tipoCarga; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}