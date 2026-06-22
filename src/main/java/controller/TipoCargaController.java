package com.car.controller;

import com.car.model.TipoCarga;
import com.car.service.TipoCargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-carga")
public class TipoCargaController {

    @Autowired
    private TipoCargaService tipoCargaService;

    // Endpoint: GET http://localhost:8080/api/tipos-carga
    @GetMapping
    public List<TipoCarga> obtenerTodos() {
        return tipoCargaService.listarTodas();
    }

    // Endpoint: POST http://localhost:8080/api/tipos-carga
    @PostMapping
    public ResponseEntity<TipoCarga> crear(@RequestBody TipoCarga tipoCarga) {
        TipoCarga nuevoTipo = tipoCargaService.guardar(tipoCarga);
        return new ResponseEntity<>(nuevoTipo, HttpStatus.CREATED);
    }
}