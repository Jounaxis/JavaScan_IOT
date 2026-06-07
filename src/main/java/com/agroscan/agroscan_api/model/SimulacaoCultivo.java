package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

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
}