package com.car.repository;

import com.car.model.TipoCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCargaRepository extends JpaRepository<TipoCarga, Long> {
    
}