package com.agroscan.agroscan_api.dto.response;

import java.time.LocalDateTime;

public record SimulacaoCultivoResponse(
        Long id,
        LocalDateTime dataSimulacao,
        String status,
        Double scoreViabilidade,
        String resultado
) {
}