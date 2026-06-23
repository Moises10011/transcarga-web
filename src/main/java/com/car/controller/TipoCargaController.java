package com.car.controller;

import com.car.model.TipoCarga;
import com.car.service.TipoCargaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-carga")
public class TipoCargaController {

    private final TipoCargaService tipoCargaService;

    public TipoCargaController(TipoCargaService tipoCargaService) {
        this.tipoCargaService = tipoCargaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoCarga>> listarTodos() {
        return ResponseEntity.ok(tipoCargaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCarga> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoCargaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TipoCarga> crear(@RequestBody TipoCarga tipoCarga) {
        return ResponseEntity.ok(tipoCargaService.crear(tipoCarga));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCarga> actualizar(@PathVariable Long id, @RequestBody TipoCarga tipoCarga) {
        return ResponseEntity.ok(tipoCargaService.actualizar(id, tipoCarga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoCargaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}