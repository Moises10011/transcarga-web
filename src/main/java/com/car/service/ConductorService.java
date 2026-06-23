package com.car.service;

import com.car.model.Conductor;
import com.car.repository.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConductorService {

    private final ConductorRepository conductorRepository;

    public List<Conductor> listarTodos() {
        return conductorRepository.findAll();
    }

    public Conductor buscarPorId(Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado con id: " + id));
    }

    public Conductor buscarPorUsuarioId(Long usuarioId) {
        return conductorRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado para usuarioId: " + usuarioId));
    }

    public Conductor crear(Conductor conductor) {
        if (conductorRepository.existsByTelefono(conductor.getTelefono())) {
            throw new RuntimeException("Ya existe un conductor con ese teléfono");
        }
        if (conductorRepository.existsByNumeroLicencia(conductor.getNumeroLicencia())) {
            throw new RuntimeException("Ya existe un conductor con esa licencia");
        }
        return conductorRepository.save(conductor);
    }

    public Conductor actualizar(Long id, Conductor datos) {
        Conductor existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setTelefono(datos.getTelefono());
        existente.setNumeroLicencia(datos.getNumeroLicencia());
        existente.setDescripcion(datos.getDescripcion());
        existente.setFotoUrl(datos.getFotoUrl());
        return conductorRepository.save(existente);
    }

    public void eliminar(Long id) {
        conductorRepository.deleteById(id);
    }
}