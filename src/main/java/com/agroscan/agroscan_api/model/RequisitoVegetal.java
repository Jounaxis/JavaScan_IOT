package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_REQUISITO_VEGETAL")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPhSoloMin() {
        return phSoloMin;
    }

    public void setPhSoloMin(Double phSoloMin) {
        this.phSoloMin = phSoloMin;
    }

    public Double getPhSoloMax() {
        return phSoloMax;
    }

    public void setPhSoloMax(Double phSoloMax) {
        this.phSoloMax = phSoloMax;
    }

    public Double getQuantidadeAgua() {
        return quantidadeAgua;
    }

    public void setQuantidadeAgua(Double quantidadeAgua) {
        this.quantidadeAgua = quantidadeAgua;
    }

    public Double getNivelLuzMin() {
        return nivelLuzMin;
    }

    public void setNivelLuzMin(Double nivelLuzMin) {
        this.nivelLuzMin = nivelLuzMin;
    }

    public String getNotasCultivo() {
        return notasCultivo;
    }

    public void setNotasCultivo(String notasCultivo) {
        this.notasCultivo = notasCultivo;
    }

    public Vegetal getVegetal() {
        return vegetal;
    }

    public void setVegetal(Vegetal vegetal) {
        this.vegetal = vegetal;
    }
}
