package com.car.controller;

import com.car.model.Carga;
import com.car.service.CargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cargas")
public class CargaController {

    @Autowired
    private CargaService cargaService;

    // Endpoint: GET http://localhost:8080/api/cargas
    @GetMapping
    public List<Carga> obtenerTodas() {
        return cargaService.listarTodos();
    }

    // Endpoint: POST http://localhost:8080/api/cargas
    @PostMapping
    public ResponseEntity<Carga> crear(@RequestBody Carga carga) {
        Carga nuevaCarga = cargaService.guardar(carga);
        return new ResponseEntity<>(nuevaCarga, HttpStatus.CREATED);
    }
}