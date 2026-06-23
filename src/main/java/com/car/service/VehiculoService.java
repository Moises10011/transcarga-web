package com.car.service;

import com.car.model.Vehiculo;
import com.car.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo buscarPorId(Long id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + id));
    }

    public List<Vehiculo> buscarPorTipo(Vehiculo.TipoVehiculo tipo) {
        return vehiculoRepository.findByTipoVehiculo(tipo);
    }

    public List<Vehiculo> buscarPorTipoCarga(Long tipoCargaId) {
        return vehiculoRepository.findByTipoCargaCompatibleId(tipoCargaId);
    }

    public List<Vehiculo> buscarPorConductor(Long conductorId) {
        return vehiculoRepository.findByConductorId(conductorId);
    }

    public Vehiculo crear(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizar(Long id, Vehiculo datos) {
        Vehiculo existente = buscarPorId(id);
        existente.setMarca(datos.getMarca());
        existente.setModelo(datos.getModelo());
        existente.setPlaca(datos.getPlaca());
        existente.setCapacidadToneladasMax(datos.getCapacidadToneladasMax());
        existente.setFotoUrl(datos.getFotoUrl());
        existente.setDescripcion(datos.getDescripcion());
        existente.setTipoVehiculo(datos.getTipoVehiculo());
        existente.setTipoCargaCompatible(datos.getTipoCargaCompatible());
        return vehiculoRepository.save(existente);
    }

    public void eliminar(Long id) {
        vehiculoRepository.deleteById(id);
    }
}