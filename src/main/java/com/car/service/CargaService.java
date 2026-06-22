package com.car.service;

import com.car.model.Carga;
import com.car.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CargaService {

    @Autowired
    private CargaRepository cargaRepository;

    
    public List<Carga> listarTodos() {
        return cargaRepository.findAll();
    }

    
    public Carga guardar(Carga carga) {
        if (carga.getPesoKg() != null && carga.getPesoKg() < 0) {
            throw new IllegalArgumentException("El peso de la carga no puede ser negativo");
        }
        if (carga.getPrecioFlete() != null && carga.getPrecioFlete() < 0) {
            throw new IllegalArgumentException("El precio del flete no puede ser negativo");
        }
        return cargaRepository.save(carga);
    }
}