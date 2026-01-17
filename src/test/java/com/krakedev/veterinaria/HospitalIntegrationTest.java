package com.krakedev.veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.krakedev.veterinaria.entity.Consulta;
import com.krakedev.veterinaria.entity.Doctor;
import com.krakedev.veterinaria.entity.Especialidad;
import com.krakedev.veterinaria.entity.Paciente;
import com.krakedev.veterinaria.repository.ConsultaRepository;
import com.krakedev.veterinaria.repository.DoctorRepository;
import com.krakedev.veterinaria.repository.EspecialidadRepository;
import com.krakedev.veterinaria.repository.PacienteRepository;

@SpringBootTest
class HospitalIntegrationTest {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Test
    void testHospitalFlow() {
        // 1. Create Especialidad
        Especialidad cardiologia = new Especialidad();
        cardiologia.setNombre("Cardiologia");
        cardiologia.setDescripcion("Corazon");
        cardiologia = especialidadRepository.save(cardiologia);

        // 2. Create Doctor
        Doctor doctor = new Doctor();
        doctor.setNombre("Juan");
        doctor.setApellido("Perez");
        doctor.setEspecialidad(cardiologia);
        doctor = doctorRepository.save(doctor);

        assertNotNull(doctor.getIdDoctor());

        // 3. Create Paciente
        Paciente paciente = new Paciente();
        paciente.setNombre("Maria");
        paciente.setApellido("Lopez");
        paciente.setEmail("maria@mail.com");
        paciente = pacienteRepository.save(paciente);

        assertNotNull(paciente.getIdPaciente());

        // 4. Create Consulta
        Consulta consulta = new Consulta();
        consulta.setFecha(LocalDate.now());
        consulta.setHora(LocalTime.now());
        consulta.setDiagnostico("Prueba de diagnostico");
        consulta.setDoctor(doctor);
        consulta.setPaciente(paciente);

        consulta = consultaRepository.save(consulta);

        assertNotNull(consulta.getIdConsulta());

        // 5. Verify Relations
        List<Consulta> consultas = consultaRepository.findAll();
        Consulta savedConsulta = consultas.get(consultas.size() - 1); // Get last one

        assertEquals(doctor.getIdDoctor(), savedConsulta.getDoctor().getIdDoctor());
        assertEquals(paciente.getIdPaciente(), savedConsulta.getPaciente().getIdPaciente());
        System.out.println("Integration Test Passed: Consulta created with Doctor and Paciente");
    }
}
