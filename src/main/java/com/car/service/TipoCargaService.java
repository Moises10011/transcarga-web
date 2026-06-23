package com.car.service;

import com.car.model.TipoCarga;
import com.car.repository.TipoCargaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoCargaService {

    private final TipoCargaRepository tipoCargaRepository;

    public TipoCargaService(TipoCargaRepository tipoCargaRepository) {
        this.tipoCargaRepository = tipoCargaRepository;
    }

    public List<TipoCarga> listarTodos() { return tipoCargaRepository.findAll(); }

    public TipoCarga buscarPorId(Long id) {
        return tipoCargaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoCarga no encontrado con id: " + id));
    }

    public TipoCarga crear(TipoCarga tipoCarga) { return tipoCargaRepository.save(tipoCarga); }

    public TipoCarga actualizar(Long id, TipoCarga datos) {
        TipoCarga existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());
        return tipoCargaRepository.save(existente);
    }

    public void eliminar(Long id) { tipoCargaRepository.deleteById(id); }
}