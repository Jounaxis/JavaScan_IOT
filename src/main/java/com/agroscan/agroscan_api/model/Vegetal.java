package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_VEGETAL")
@NoArgsConstructor
@AllArgsConstructor
public class Vegetal extends EntidadeBase {

    @Column(name = "NOME_COMUM", nullable = false, length = 100)
    private String nomeComum;

    @Column(name = "NOME_CIENTIFICO", length = 120)
    private String nomeCientifico;

    @Column(name = "FAMILIA_BOTANICA", length = 100)
    private String familiaBotanica;

    @Column(name = "DESCRICAO", length = 500)
    private String descricao;

    @Column(name = "CICLO_CRESCIMENTO_DIAS")
    private Integer cicloCrescimentoDias;

    @OneToMany(mappedBy = "vegetal")
    private List<RequisitoVegetal> requisitos;

    @OneToMany(mappedBy = "vegetal")
    private List<SimulacaoCultivo> simulacoes;



    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getFamiliaBotanica() {
        return familiaBotanica;
    }

    public void setFamiliaBotanica(String familiaBotanica) {
        this.familiaBotanica = familiaBotanica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCicloCrescimentoDias() {
        return cicloCrescimentoDias;
    }

    public void setCicloCrescimentoDias(Integer cicloCrescimentoDias) {
        this.cicloCrescimentoDias = cicloCrescimentoDias;
    }

    public List<RequisitoVegetal> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<RequisitoVegetal> requisitos) {
        this.requisitos = requisitos;
    }

    public List<SimulacaoCultivo> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(List<SimulacaoCultivo> simulacoes) {
        this.simulacoes = simulacoes;
    }
}