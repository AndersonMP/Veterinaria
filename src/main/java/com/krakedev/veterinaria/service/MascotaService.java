package com.krakedev.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaService {
    Mascota registrarMascota(Mascota mascota);

    List<Mascota> listarMascotas();

    Optional<Mascota> buscarPorNombre(String nombre);

    Optional<Mascota> buscarPorId(Long id);

    Mascota actualizarMascota(Long id, Mascota mascota);

    Mascota cambiarEstadoMascota(Long id, EstadoMascota estadoMascota);

    List<Mascota> listarMascotasPorEstado(EstadoMascota estadoMascota);

    void eliminarMascota(Long id);
}
