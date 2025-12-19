package com.krakedev.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.service.MascotaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {
    private final MascotaService mascotaService;

    // private List<Mascota> mascotas = new ArrayList<>();

    // public MascotaController() {
    // mascotas.add(new Mascota(
    // null, "Firulais", "Perro", 3, "Juan Perez", LocalDate.now()));
    // mascotas.add(new Mascota(
    // null, "Michi", "Gato", 2, "Ana Gomez", LocalDate.now()));
    // mascotas.add(new Mascota(
    // null, "Nemo", "Pez", 1, "Carlos Lopez", LocalDate.now()));
    // mascotas.add(new Mascota(
    // null, "Bubbles", "Pez", 1, "Maria Rodriguez", LocalDate.now()));
    // mascotas.add(new Mascota(
    // null, "Rex", "Perro", 4, "Luis Martínez", LocalDate.now()));
    // }

    @GetMapping()
    public ResponseEntity<List<Mascota>> listarMascotas() {
        // return mascotas;
        List<Mascota> mascotas = mascotaService.listarMascotas();
        return ResponseEntity.ok().body(mascotas);
    }

    // @GetMapping("/{id}")
    // public Mascota obtenerMascotaPorId(@PathVariable int id) {
    // Optional<Mascota> mascota = mascotas.stream()
    // .filter(m -> m.getIdMascota() == id)
    // .findFirst();

    // return mascota.orElse(null);
    // }

    @PostMapping("/registrar")
    public ResponseEntity<Mascota> crearMascota(@RequestBody Mascota mascota) {

        // mascotas.add(nuevaMascota);
        // return nuevaMascota;
        Mascota nuevaMascota = mascotaService.registrarMascota(mascota);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity<?> buscarPorNombre(@PathVariable String nombre) {
        Optional<Mascota> mascota = mascotaService.buscarPorNombre(nombre);
        return mascota.isPresent() ? ResponseEntity.ok().body(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Mascota con nombre " + nombre + " no encontrada");
    }

    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Mascota> mascota = mascotaService.buscarPorId(id);
        return mascota.isPresent() ? ResponseEntity.ok().body(mascota.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Mascota con ID " + id + " no encontrada");
    }

    // @DeleteMapping("/{id}")
    // public void eliminarMascota(@PathVariable int id) {
    // mascotas.removeIf(m -> m.getIdMascota() == id);
    // }
}
