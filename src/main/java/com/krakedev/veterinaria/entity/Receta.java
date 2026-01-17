package com.krakedev.veterinaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Long idReceta;

    @Column(name = "medicamentos")
    private String medicamentos;

    @Column(name = "indicaciones")
    private String indicaciones;

    @OneToOne
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", unique = true)
    private Consulta consulta;
}
