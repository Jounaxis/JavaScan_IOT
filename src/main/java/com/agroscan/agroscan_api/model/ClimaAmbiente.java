package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CLIMA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClimaAmbiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIMA")
    private Long id;

    private Double tempMin;
    private Double tempMax;
    private Double nivelLuz;
    private Double nivelAgua;
    private Double nivelVento;
    private String descricaoGeral;
}