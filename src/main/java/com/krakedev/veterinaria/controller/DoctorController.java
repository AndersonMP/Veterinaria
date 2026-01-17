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

import com.krakedev.veterinaria.entity.Doctor;
import com.krakedev.veterinaria.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/doctores")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/registrar")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id) {
        try {
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        if (doctor.isPresent()) {
            return ResponseEntity.ok(doctor.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor with ID " + id + " not found");
        }
    }
}
