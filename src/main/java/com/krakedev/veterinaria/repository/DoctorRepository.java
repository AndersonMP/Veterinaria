package com.krakedev.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
