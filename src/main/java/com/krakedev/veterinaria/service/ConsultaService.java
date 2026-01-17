package com.krakedev.veterinaria.service;

import java.util.List;

import com.krakedev.veterinaria.entity.Consulta;

public interface ConsultaService {
    Consulta createConsulta(Consulta consulta);

    List<Consulta> getAllConsultas();
}
