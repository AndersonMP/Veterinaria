package com.krakedev.veterinaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.Consulta;
import com.krakedev.veterinaria.repository.ConsultaRepository;
import com.krakedev.veterinaria.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public Consulta createConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }
}
