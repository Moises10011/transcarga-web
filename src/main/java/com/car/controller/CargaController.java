package com.car.controller;

import com.car.model.Carga;
import com.car.service.CargaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cargas")
public class CargaController {

    private final CargaService cargaService;

    public CargaController(CargaService cargaService) {
        this.cargaService = cargaService;
    }

    @GetMapping
    public ResponseEntity<List<Carga>> listarTodas() {
        return ResponseEntity.ok(cargaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carga> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cargaService.buscarPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carga>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(cargaService.listarPorUsuario(usuarioId));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Carga>> listarPorEstado(@PathVariable Carga.EstadoCarga estado) {
        return ResponseEntity.ok(cargaService.listarPorEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Carga> crear(@RequestBody Carga carga) {
        return ResponseEntity.ok(cargaService.crear(carga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carga> actualizar(@PathVariable Long id, @RequestBody Carga carga) {
        return ResponseEntity.ok(cargaService.actualizar(id, carga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cargaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}