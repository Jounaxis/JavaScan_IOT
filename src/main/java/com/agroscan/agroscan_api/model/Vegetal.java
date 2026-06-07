package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_VEGETAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VEGETAL")
    private Long id;

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
}