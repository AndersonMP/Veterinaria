package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
