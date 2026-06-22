package com.car.service;

import com.car.model.TipoCarga;
import com.car.repository.TipoCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoCargaService {

    @Autowired
    private TipoCargaRepository tipoCargaRepository;


    public List<TipoCarga> listarTodas() {
        return tipoCargaRepository.findAll();
    }

    
    public TipoCarga guardar(TipoCarga tipoCarga) {
        return tipoCargaRepository.save(tipoCarga);
    }
}