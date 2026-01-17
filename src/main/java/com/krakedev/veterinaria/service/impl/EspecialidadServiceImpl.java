package com.krakedev.veterinaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.Especialidad;
import com.krakedev.veterinaria.repository.EspecialidadRepository;
import com.krakedev.veterinaria.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }
}
