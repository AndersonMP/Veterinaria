package com.krakedev.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.Doctor;

public interface DoctorService {
    Doctor createDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctor);

    List<Doctor> getAllDoctors();

    void deleteDoctor(Long id);

    Optional<Doctor> getDoctorById(Long id);
}
