package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SoloRequest(

        @NotBlank(message = "O tipo do solo é obrigatório.")
        @Size(min = 3, max = 100, message = "O tipo do solo deve ter entre 3 e 100 caracteres.")
        String tipoSolo,

        @NotNull(message = "O pH é obrigatório.")
        @Positive(message = "O pH deve ser maior que zero.")
        Double phEstimado,

        @NotBlank(message = "O nível de nutrientes é obrigatório.")
        String nivelNutrientes,

        @NotNull(message = "A retenção de água é obrigatória.")
        @Positive(message = "A retenção de água deve ser maior que zero.")
        Double retencaoAgua,

        @NotBlank(message = "A composição principal é obrigatória.")
        String composicaoPrincipal,

        String observacoes
) {
}
