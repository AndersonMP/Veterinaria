package com.krakedev.veterinaria.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.repository.MascotaRepository;
import com.krakedev.veterinaria.service.MascotaService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MascotaServiceImpl implements MascotaService {
    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        mascota.setIdMascota(null);
        mascota.setFechaRegistro(LocalDate.now());

        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Mascota> buscarPorId(Long id) {
        return mascotaRepository.findByIdMascota(id);
    }

    @Override
    @SneakyThrows
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrada con ID: " + id));

        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setNombreDueno(mascota.getNombreDueno());
        mascotaExistente.setFechaRegistro(mascota.getFechaRegistro());
        mascotaExistente.setEstadoMascota(mascota.getEstadoMascota());

        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    @SneakyThrows
    public void eliminarMascota(Long id) {
        mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrada con ID: " + id));

        mascotaRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public Mascota cambiarEstadoMascota(Long id, EstadoMascota estadoMascota) {
        Mascota mascotaExistente = mascotaRepository.findById(id)
                .orElseThrow(() -> new Exception("Mascota no encontrada con ID: " + id));

        mascotaExistente.setEstadoMascota(estadoMascota);

        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    public List<Mascota> listarMascotasPorEstado(EstadoMascota estadoMascota) {
        return mascotaRepository.findByEstadoMascota(estadoMascota);
    }

}
