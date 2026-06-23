package com.car.repository;

import com.car.model.Carga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CargaRepository extends JpaRepository<Carga, Long> {
    List<Carga> findByUsuarioId(Long usuarioId);
    List<Carga> findByEstado(Carga.EstadoCarga estado);
}