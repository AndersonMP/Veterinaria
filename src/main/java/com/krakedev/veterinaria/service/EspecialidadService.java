package com.krakedev.veterinaria.service;

import java.util.List;

import com.krakedev.veterinaria.entity.Especialidad;

public interface EspecialidadService {
    Especialidad createEspecialidad(Especialidad especialidad);

    List<Especialidad> getAllEspecialidades();
}
