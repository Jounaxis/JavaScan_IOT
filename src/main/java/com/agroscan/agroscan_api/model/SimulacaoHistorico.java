package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_SIMULACAO_HISTORICO")
public class SimulacaoHistorico {

    @EmbeddedId
    private SimulacaoHistoricoId id;

    @Column(length = 300)
    private String observacao;

    public SimulacaoHistoricoId getId() {
        return id;
    }

    public void setId(SimulacaoHistoricoId id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}