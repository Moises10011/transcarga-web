package com.car.repository;

import com.car.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByTipoVehiculo(Vehiculo.TipoVehiculo tipoVehiculo);
    List<Vehiculo> findByConductorId(Long conductorId);
    List<Vehiculo> findByTipoCargaCompatibleId(Long tipoCargaId);
}