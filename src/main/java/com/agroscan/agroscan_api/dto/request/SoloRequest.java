package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SoloRequest(

        @NotBlank(message = "O tipo do solo é obrigatório.")
        @Size(min = 3, max = 100)
        String tipoSolo,

        @NotBlank(message = "O pH é obrigatório.")
        Double phEstimado,

        @NotBlank(message = "O nível de nutrientes é obrigatório.")
        String nivelNutrientes,

        @NotBlank(message = "A retenção de água é obrigatória.")
        Double retencaoAgua,

        @NotBlank(message = "A composição principal é obrigatória.")
        String composicaoPrincipal,

        String observacoes
) {
}
