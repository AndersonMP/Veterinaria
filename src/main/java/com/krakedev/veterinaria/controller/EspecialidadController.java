package com.krakedev.veterinaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Especialidad;
import com.krakedev.veterinaria.service.EspecialidadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/especialidades")
@RequiredArgsConstructor
public class EspecialidadController {

    private final EspecialidadService especialidadService;

    @PostMapping("/registrar")
    public ResponseEntity<Especialidad> createEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad newEspecialidad = especialidadService.createEspecialidad(especialidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEspecialidad);
    }

    @GetMapping
    public ResponseEntity<List<Especialidad>> getAllEspecialidades() {
        return ResponseEntity.ok(especialidadService.getAllEspecialidades());
    }
}
