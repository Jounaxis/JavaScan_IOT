package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SIMULACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimulacaoCultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SIMULACAO")
    private Long id;

    private LocalDateTime dataSimulacao = LocalDateTime.now();

    private String status;
    private Double scoreViabilidade;
    private String resultado;

    @Embedded
    private Localizacao localizacao;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private UsuarioApp usuario;

    @ManyToOne
    @JoinColumn(name = "ID_VEGETAL")
    private Vegetal vegetal;

    @ManyToOne
    @JoinColumn(name = "ID_SOLO")
    private Solo solo;

    @ManyToOne
    @JoinColumn(name = "ID_CLIMA")
    private ClimaAmbiente clima;

    @ManyToOne
    @JoinColumn(name = "ID_CORPO")
    private CorpoCeleste corpoCeleste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataSimulacao() {
        return dataSimulacao;
    }

    public void setDataSimulacao(LocalDateTime dataSimulacao) {
        this.dataSimulacao = dataSimulacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getScoreViabilidade() {
        return scoreViabilidade;
    }

    public void setScoreViabilidade(Double scoreViabilidade) {
        this.scoreViabilidade = scoreViabilidade;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public UsuarioApp getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioApp usuario) {
        this.usuario = usuario;
    }

    public Vegetal getVegetal() {
        return vegetal;
    }

    public void setVegetal(Vegetal vegetal) {
        this.vegetal = vegetal;
    }

    public Solo getSolo() {
        return solo;
    }

    public void setSolo(Solo solo) {
        this.solo = solo;
    }

    public ClimaAmbiente getClima() {
        return clima;
    }

    public void setClima(ClimaAmbiente clima) {
        this.clima = clima;
    }

    public CorpoCeleste getCorpoCeleste() {
        return corpoCeleste;
    }

    public void setCorpoCeleste(CorpoCeleste corpoCeleste) {
        this.corpoCeleste = corpoCeleste;
    }
}