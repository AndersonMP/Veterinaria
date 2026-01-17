package com.krakedev.veterinaria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.Paciente;
import com.krakedev.veterinaria.repository.PacienteRepository;
import com.krakedev.veterinaria.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente pacienteDetails) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no econtrado con id " + id));

        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setApellido(pacienteDetails.getApellido());
        paciente.setEmail(pacienteDetails.getEmail());
        paciente.setTelefono(pacienteDetails.getTelefono());

        return pacienteRepository.save(paciente);
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void deletePaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id " + id));
        pacienteRepository.delete(paciente);
    }
}
