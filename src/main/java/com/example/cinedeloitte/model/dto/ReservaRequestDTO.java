package com.example.cinedeloitte.model.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class ReservaRequestDTO {
    @NotNull
    private Long salaId;

    @NotBlank
    private String nomeResponsavel;

    @NotNull
    @Future
    private OffsetDateTime startIn;

    @NotNull
    @Future
    private OffsetDateTime endIn;

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
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
