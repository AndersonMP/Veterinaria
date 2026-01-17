package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
