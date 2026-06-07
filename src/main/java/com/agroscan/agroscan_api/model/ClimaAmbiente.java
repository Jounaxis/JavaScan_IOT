package com.agroscan.agroscan_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CLIMA")
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

    public Double getNivelLuz() {
        return nivelLuz;
    }

    public void setNivelLuz(Double nivelLuz) {
        this.nivelLuz = nivelLuz;
    }

    public Double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(Double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public Double getNivelVento() {
        return nivelVento;
    }

    public void setNivelVento(Double nivelVento) {
        this.nivelVento = nivelVento;
    }

    public String getDescricaoGeral() {
        return descricaoGeral;
    }

    public void setDescricaoGeral(String descricaoGeral) {
        this.descricaoGeral = descricaoGeral;
    }
}