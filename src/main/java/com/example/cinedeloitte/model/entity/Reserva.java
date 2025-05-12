package com.example.cinedeloitte.model.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @Column(nullable = false, name="nome_responsavel")
    private String nomeResponsavel;

    @Column(nullable = false, name="start_in")
    private OffsetDateTime startIn;

    @Column(nullable = false, name="end_in")
    private OffsetDateTime endIn;

}
