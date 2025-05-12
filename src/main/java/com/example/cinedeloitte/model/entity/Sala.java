package com.example.cinedeloitte.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Data
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name="nome")
    private String nome;

    @Column(nullable = false, name="capacidade")
    private int capacidade;

    @Column(nullable = false, name="localizacao")
    private String localizacao;

}
