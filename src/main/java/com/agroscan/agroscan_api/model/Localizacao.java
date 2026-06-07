package com.agroscan.agroscan_api.model;


import jakarta.persistence.Embeddable;

@Embeddable
public class Localizacao {

    private String planeta;
    private String regiao;

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
}