package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
