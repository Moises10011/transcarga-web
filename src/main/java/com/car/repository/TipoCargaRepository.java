package com.car.repository;

import com.car.model.TipoCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TipoCargaRepository extends JpaRepository<TipoCarga, Long> {
    Optional<TipoCarga> findByNombre(String nombre);
}