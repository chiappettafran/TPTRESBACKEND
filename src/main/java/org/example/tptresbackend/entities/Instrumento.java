package org.example.tptresbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instrumento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrumento", length = 256)
    private String instrumento;

    @Column(name = "marca", length = 256)
    private String marca;

    @Column(name = "modelo", length = 256)
    private String modelo;

    @Column(name = "imagen", length = 256)
    private String imagen;

    @Column(name = "precio")
    private double precio;

    @Column(name = "costoEnvio", length = 20)
    private String costoEnvio;

    @Column(name = "cantidadVendida")
    private Long cantidadVendida;

    @Column(name = "descripcion", length = 2048)
    private String descripcion;


}
