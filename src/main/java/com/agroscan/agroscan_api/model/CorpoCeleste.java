package com.agroscan.agroscan_api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_CORPO_CELESTE")
@Getter
@Setter
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
}
