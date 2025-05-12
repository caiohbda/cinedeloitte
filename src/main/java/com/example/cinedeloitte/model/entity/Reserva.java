package com.example.cinedeloitte.model.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public OffsetDateTime getStartIn() {
        return startIn;
    }

    public void setStartIn(OffsetDateTime startIn) {
        this.startIn = startIn;
    }

    public OffsetDateTime getEndIn() {
        return endIn;
    }

    public void setEndIn(OffsetDateTime endIn) {
        this.endIn = endIn;
    }
}
