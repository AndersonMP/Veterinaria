package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
}
