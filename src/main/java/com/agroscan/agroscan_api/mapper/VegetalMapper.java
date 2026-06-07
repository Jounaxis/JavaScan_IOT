package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.VegetalRequest;
import com.agroscan.agroscan_api.dto.response.VegetalResponse;
import com.agroscan.agroscan_api.model.Vegetal;

public class VegetalMapper {

    public static Vegetal toEntity(VegetalRequest request) {

        Vegetal vegetal = new Vegetal();

        vegetal.setNomeComum(request.nomeComum());
        vegetal.setNomeCientifico(request.nomeCientifico());
        vegetal.setFamiliaBotanica(request.familiaBotanica());
        vegetal.setDescricao(request.descricao());
        vegetal.setCicloCrescimentoDias(request.cicloCrescimentoDias());

        return vegetal;
    }

    public static VegetalResponse toResponse(Vegetal vegetal) {

        return new VegetalResponse(
                vegetal.getId(),
                vegetal.getNomeComum(),
                vegetal.getNomeCientifico(),
                vegetal.getFamiliaBotanica(),
                vegetal.getDescricao(),
                vegetal.getCicloCrescimentoDias()
        );
    }
}