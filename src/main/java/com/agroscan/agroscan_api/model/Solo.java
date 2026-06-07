package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_SOLO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Solo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SOLO")
    private Long id;

    private String tipoSolo;
    private Double phEstimado;
    private String nivelNutrientes;
    private Double retencaoAgua;
    private String composicaoPrincipal;
    private String observacoes;
}