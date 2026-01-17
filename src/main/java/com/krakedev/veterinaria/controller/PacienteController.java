package com.krakedev.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Paciente;
import com.krakedev.veterinaria.service.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        try {
            Paciente updatedPaciente = pacienteService.updatePaciente(id, paciente);
            return ResponseEntity.ok(updatedPaciente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.getPacienteById(id);
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente with ID " + id + " not found");
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id) {
        try {
            pacienteService.deletePaciente(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
