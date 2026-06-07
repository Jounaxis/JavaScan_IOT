package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_REQUISITO_VEGETAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequisitoVegetal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REQUISITO")
    private Long id;

    @Column(name = "TEMP_MIN")
    private Double tempMin;

    @Column(name = "TEMP_MAX")
    private Double tempMax;

    @Column(name = "PH_SOLO_MIN")
    private Double phSoloMin;

    @Column(name = "PH_SOLO_MAX")
    private Double phSoloMax;

    @Column(name = "QNTD_AGUA")
    private Double quantidadeAgua;

    @Column(name = "NIVEL_LUZ_MIN")
    private Double nivelLuzMin;

    @Column(name = "NOTAS_CULTIVO", length = 500)
    private String notasCultivo;

    @ManyToOne
    @JoinColumn(name = "ID_VEGETAL")
    private Vegetal vegetal;
}
