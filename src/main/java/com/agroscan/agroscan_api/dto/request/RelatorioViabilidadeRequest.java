package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RelatorioViabilidadeRequest(

        @NotBlank
        String fatorAvaliado,

        @NotBlank
        Double valorEncontrado,

        @NotBlank
        Double valorEsperado,

        @NotBlank
        String statusFator,

        String recomendacao
) {
}