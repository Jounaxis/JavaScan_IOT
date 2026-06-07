package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_SOLO")
@NoArgsConstructor
@AllArgsConstructor
public class Solo extends EntidadeBase{

    private String tipoSolo;
    private Double phEstimado;
    private String nivelNutrientes;
    private Double retencaoAgua;
    private String composicaoPrincipal;
    private String observacoes;


    public String getTipoSolo() {
        return tipoSolo;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }

    public Double getPhEstimado() {
        return phEstimado;
    }

    public void setPhEstimado(Double phEstimado) {
        this.phEstimado = phEstimado;
    }

    public String getNivelNutrientes() {
        return nivelNutrientes;
    }

    public void setNivelNutrientes(String nivelNutrientes) {
        this.nivelNutrientes = nivelNutrientes;
    }

    public Double getRetencaoAgua() {
        return retencaoAgua;
    }

    public void setRetencaoAgua(Double retencaoAgua) {
        this.retencaoAgua = retencaoAgua;
    }

    public String getComposicaoPrincipal() {
        return composicaoPrincipal;
    }

    public void setComposicaoPrincipal(String composicaoPrincipal) {
        this.composicaoPrincipal = composicaoPrincipal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}