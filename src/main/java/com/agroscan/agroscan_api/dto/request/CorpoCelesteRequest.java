package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.*;

public record CorpoCelesteRequest(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @NotBlank(message = "O tipo é obrigatório.")
        String tipo,

        @Positive(message = "A gravidade deve ser positiva.")
        Double gravidadeMs2,

        @Positive(message = "A temperatura média deve ser positiva.")
        Double temperaturaMedia,

        @NotBlank(message = "A composição atmosférica é obrigatória.")
        String composicaoAtmosfera,

        String descricao
) {
}