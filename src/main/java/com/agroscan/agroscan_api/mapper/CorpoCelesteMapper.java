package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.CorpoCelesteRequest;
import com.agroscan.agroscan_api.dto.response.CorpoCelesteResponse;
import com.agroscan.agroscan_api.model.CorpoCeleste;

public class CorpoCelesteMapper {

    public static CorpoCeleste toEntity(CorpoCelesteRequest request) {
        CorpoCeleste corpo = new CorpoCeleste();

        corpo.setNome(request.nome());
        corpo.setTipo(request.tipo());
        corpo.setGravidadeMs2(request.gravidadeMs2());
        corpo.setTemperaturaMedia(request.temperaturaMedia());
        corpo.setComposicaoAtmosfera(request.composicaoAtmosfera());
        corpo.setDescricao(request.descricao());

        return corpo;
    }

    public static CorpoCelesteResponse toResponse(CorpoCeleste corpo) {
        return new CorpoCelesteResponse(
                corpo.getId(),
                corpo.getNome(),
                corpo.getTipo(),
                corpo.getGravidadeMs2(),
                corpo.getTemperaturaMedia(),
                corpo.getComposicaoAtmosfera(),
                corpo.getDescricao()
        );
    }
}