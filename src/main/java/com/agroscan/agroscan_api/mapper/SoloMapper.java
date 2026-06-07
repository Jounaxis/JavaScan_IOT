package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.SoloRequest;
import com.agroscan.agroscan_api.dto.response.SoloResponse;
import com.agroscan.agroscan_api.model.Solo;

public class SoloMapper {

    public static Solo toEntity(SoloRequest request) {
        Solo solo = new Solo();

        solo.setTipoSolo(request.tipoSolo());
        solo.setPhEstimado(request.phEstimado());
        solo.setNivelNutrientes(request.nivelNutrientes());
        solo.setRetencaoAgua(request.retencaoAgua());
        solo.setComposicaoPrincipal(request.composicaoPrincipal());
        solo.setObservacoes(request.observacoes());

        return solo;
    }

    public static SoloResponse toResponse(Solo solo) {
        return new SoloResponse(
                solo.getId(),
                solo.getTipoSolo(),
                solo.getPhEstimado(),
                solo.getNivelNutrientes(),
                solo.getRetencaoAgua(),
                solo.getComposicaoPrincipal(),
                solo.getObservacoes()
        );
    }
}