package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.*;

public record SimulacaoCultivoRequest(

        @NotNull(message = "O ID do usuário é obrigatório.")
        @Positive(message = "O ID do usuário deve ser maior que zero.")
        Long usuarioId,

        @NotNull(message = "O ID do vegetal é obrigatório.")
        @Positive(message = "O ID do vegetal deve ser maior que zero.")
        Long vegetalId,

        @NotNull(message = "O ID do solo é obrigatório.")
        @Positive(message = "O ID do solo deve ser maior que zero.")
        Long soloId,

        @NotNull(message = "O ID do clima é obrigatório.")
        @Positive(message = "O ID do clima deve ser maior que zero.")
        Long climaId,

        @NotNull(message = "O ID do corpo celeste é obrigatório.")
        @Positive(message = "O ID do corpo celeste deve ser maior que zero.")
        Long corpoCelesteId,

        @NotNull(message = "A temperatura é obrigatória.")
        @DecimalMin(value = "-100.0", message = "Temperatura inválida.")
        @DecimalMax(value = "200.0", message = "Temperatura inválida.")
        Double temperatura,

        @NotNull(message = "A umidade é obrigatória.")
        @Min(value = 0, message = "A umidade deve estar entre 0 e 100.")
        @Max(value = 100, message = "A umidade deve estar entre 0 e 100.")
        Integer umidade,

        @NotNull(message = "O score de viabilidade é obrigatório.")
        @DecimalMin(value = "0.0", message = "O score deve estar entre 0 e 100.")
        @DecimalMax(value = "100.0", message = "O score deve estar entre 0 e 100.")
        Double scoreViabilidade
) {
}