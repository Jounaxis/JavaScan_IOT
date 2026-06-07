package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CORPO_CELESTE")
@NoArgsConstructor
@AllArgsConstructor
public class CorpoCeleste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CORPO")
    private Long id;

    private String nome;
    private String tipo;
    private Double gravidadeMs2;
    private Double temperaturaMedia;
    private String composicaoAtmosfera;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getGravidadeMs2() {
        return gravidadeMs2;
    }

    public void setGravidadeMs2(Double gravidadeMs2) {
        this.gravidadeMs2 = gravidadeMs2;
    }

    public Double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public String getComposicaoAtmosfera() {
        return composicaoAtmosfera;
    }

    public void setComposicaoAtmosfera(String composicaoAtmosfera) {
        this.composicaoAtmosfera = composicaoAtmosfera;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
