package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RELATORIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioViabilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RELATORIO")
    private Long id;

    private String fatorAvaliado;
    private Double valorEncontrado;
    private Double valorEsperado;
    private String statusFator;
    private String recomendacao;

    private LocalDateTime dataGeracao = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "ID_SIMULACAO")
    private SimulacaoCultivo simulacao;
}