package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.Positive;

public record ClimaAmbienteRequest(

        @Positive
        Double tempMin,

        @Positive
        Double tempMax,

        @Positive
        Double nivelLuz,

        @Positive
        Double nivelAgua,

        @Positive
        Double nivelVento,

        String descricaoGeral
) {
}