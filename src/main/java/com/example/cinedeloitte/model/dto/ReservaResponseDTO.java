package com.example.cinedeloitte.model.dto;

import java.time.OffsetDateTime;

public class ReservaResponseDTO {
    private Long id;
    private String nomeResponsavel;
    private OffsetDateTime startIn;
    private OffsetDateTime endIn;
    private SalaResponseDTO sala;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public SalaResponseDTO getSala() {
        return sala;
    }

    public void setSala(SalaResponseDTO sala) {
        this.sala = sala;
    }
}
