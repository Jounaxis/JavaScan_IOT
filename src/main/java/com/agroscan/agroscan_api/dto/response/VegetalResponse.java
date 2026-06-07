package com.agroscan.agroscan_api.dto.response;

public record VegetalResponse(
        Long id,
        String nomeComum,
        String nomeCientifico,
        String familiaBotanica,
        String descricao,
        Integer cicloCrescimentoDias
) {
}