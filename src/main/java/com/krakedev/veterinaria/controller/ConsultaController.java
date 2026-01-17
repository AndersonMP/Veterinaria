package com.krakedev.veterinaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Consulta;
import com.krakedev.veterinaria.service.ConsultaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping("/registrar")
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
        
        Consulta newConsulta = consultaService.createConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConsulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> getAllConsultas() {
        return ResponseEntity.ok(consultaService.getAllConsultas());
    }
}
