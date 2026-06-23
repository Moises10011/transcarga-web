package com.car.service;

import com.car.model.Carga;
import com.car.repository.CargaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CargaService {

    private final CargaRepository cargaRepository;

    public List<Carga> listarTodas() {
        return cargaRepository.findAll();
    }

    public Carga buscarPorId(Long id) {
        return cargaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carga no encontrada con id: " + id));
    }

    public List<Carga> listarPorUsuario(Long usuarioId) {
        return cargaRepository.findByUsuarioId(usuarioId);
    }

    public List<Carga> listarPorEstado(Carga.EstadoCarga estado) {
        return cargaRepository.findByEstado(estado);
    }

    public Carga crear(Carga carga) {
        carga.setEstado(Carga.EstadoCarga.PENDIENTE);
        return cargaRepository.save(carga);
    }

    public Carga actualizar(Long id, Carga datos) {
        Carga existente = buscarPorId(id);
        existente.setDescripcionEnvio(datos.getDescripcionEnvio());
        existente.setPesoKg(datos.getPesoKg());
        existente.setPrecioFlete(datos.getPrecioFlete());
        existente.setEstado(datos.getEstado());
        existente.setTipoCarga(datos.getTipoCarga());
        existente.setVehiculo(datos.getVehiculo());
        return cargaRepository.save(existente);
    }

    public void eliminar(Long id) {
        cargaRepository.deleteById(id);
    }
}