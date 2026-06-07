package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RELATORIO")
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioViabilidade extends EntidadeBase {


    private String fatorAvaliado;
    private Double valorEncontrado;
    private Double valorEsperado;
    private String statusFator;
    private String recomendacao;

    private LocalDateTime dataGeracao = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "ID_SIMULACAO")
    private SimulacaoCultivo simulacao;

    public String getFatorAvaliado() {
        return fatorAvaliado;
    }

    public void setFatorAvaliado(String fatorAvaliado) {
        this.fatorAvaliado = fatorAvaliado;
    }

    public Double getValorEncontrado() {
        return valorEncontrado;
    }

    public void setValorEncontrado(Double valorEncontrado) {
        this.valorEncontrado = valorEncontrado;
    }

    public Double getValorEsperado() {
        return valorEsperado;
    }

    public void setValorEsperado(Double valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public String getStatusFator() {
        return statusFator;
    }

    public void setStatusFator(String statusFator) {
        this.statusFator = statusFator;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public SimulacaoCultivo getSimulacao() {
        return simulacao;
    }

    public void setSimulacao(SimulacaoCultivo simulacao) {
        this.simulacao = simulacao;
    }
}