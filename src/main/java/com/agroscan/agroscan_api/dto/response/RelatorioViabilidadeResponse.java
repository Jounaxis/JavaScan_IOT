package com.agroscan.agroscan_api.dto.response;

import java.time.LocalDateTime;

public record RelatorioViabilidadeResponse(
        Long id,
        String fatorAvaliado,
        Double valorEncontrado,
        Double valorEsperado,
        String statusFator,
        String recomendacao,
        LocalDateTime dataGeracao
) {
}