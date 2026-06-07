package com.agroscan.agroscan_api.dto.response;

public record ClimaAmbienteResponse(
        Long id,
        Double tempMin,
        Double tempMax,
        Double nivelLuz,
        Double nivelAgua,
        Double nivelVento,
        String descricaoGeral
) {
}