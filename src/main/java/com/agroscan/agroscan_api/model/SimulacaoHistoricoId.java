package com.agroscan.agroscan_api.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SimulacaoHistoricoId implements Serializable {

    private Long simulacaoId;
    private Long usuarioId;

    public SimulacaoHistoricoId() {
    }

    public SimulacaoHistoricoId(Long simulacaoId, Long usuarioId) {
        this.simulacaoId = simulacaoId;
        this.usuarioId = usuarioId;
    }

    public Long getSimulacaoId() {
        return simulacaoId;
    }

    public void setSimulacaoId(Long simulacaoId) {
        this.simulacaoId = simulacaoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimulacaoHistoricoId that)) return false;
        return Objects.equals(simulacaoId, that.simulacaoId)
                && Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simulacaoId, usuarioId);
    }
}