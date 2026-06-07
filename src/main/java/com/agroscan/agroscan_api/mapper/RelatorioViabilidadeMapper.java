package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.RelatorioViabilidadeRequest;
import com.agroscan.agroscan_api.dto.response.RelatorioViabilidadeResponse;
import com.agroscan.agroscan_api.model.RelatorioViabilidade;

public class RelatorioViabilidadeMapper {

    public static RelatorioViabilidade toEntity(RelatorioViabilidadeRequest request) {
        RelatorioViabilidade relatorio = new RelatorioViabilidade();

        relatorio.setFatorAvaliado(request.fatorAvaliado());
        relatorio.setValorEncontrado(request.valorEncontrado());
        relatorio.setValorEsperado(request.valorEsperado());
        relatorio.setStatusFator(request.statusFator());
        relatorio.setRecomendacao(request.recomendacao());

        return relatorio;
    }

    public static RelatorioViabilidadeResponse toResponse(RelatorioViabilidade relatorio) {
        return new RelatorioViabilidadeResponse(
                relatorio.getId(),
                relatorio.getFatorAvaliado(),
                relatorio.getValorEncontrado(),
                relatorio.getValorEsperado(),
                relatorio.getStatusFator(),
                relatorio.getRecomendacao(),
                relatorio.getDataGeracao()
        );
    }
}