package com.agroscan.agroscan_api.dto.response;

public record CorpoCelesteResponse(
        Long id,
        String nome,
        String tipo,
        Double gravidadeMs2,
        Double temperaturaMedia,
        String composicaoAtmosfera,
        String descricao
) {
}