package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
}
