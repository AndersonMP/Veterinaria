package com.krakedev.veterinaria.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.krakedev.veterinaria.entity.Mascota;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    private List<Mascota> mascotas = new ArrayList<>();

    public MascotaController() {
        mascotas.add(new Mascota(
                null, "Firulais", "Perro", 3, "Juan Perez", LocalDate.now()));
        mascotas.add(new Mascota(
                null, "Michi", "Gato", 2, "Ana Gomez", LocalDate.now()));
        mascotas.add(new Mascota(
                null, "Nemo", "Pez", 1, "Carlos Lopez", LocalDate.now()));
        mascotas.add(new Mascota(
                null, "Bubbles", "Pez", 1, "Maria Rodriguez", LocalDate.now()));
        mascotas.add(new Mascota(
                null, "Rex", "Perro", 4, "Luis Martínez", LocalDate.now()));
    }

    @GetMapping()
    public List<Mascota> listarMascotas() {
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaPorId(@PathVariable int id) {
        Optional<Mascota> mascota = mascotas.stream()
                .filter(m -> m.getIdMascota() == id)
                .findFirst();

        return mascota.orElse(null);
    }

    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota nuevaMascota) {

        mascotas.add(nuevaMascota);
        return nuevaMascota;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable int id) {
        mascotas.removeIf(m -> m.getIdMascota() == id);
    }
}
