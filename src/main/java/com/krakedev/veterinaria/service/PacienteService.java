package com.krakedev.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.Paciente;

public interface PacienteService {
    Paciente createPaciente(Paciente paciente);

    Paciente updatePaciente(Long id, Paciente paciente);

    List<Paciente> getAllPacientes();

    Optional<Paciente> getPacienteById(Long id);

    void deletePaciente(Long id);
}
