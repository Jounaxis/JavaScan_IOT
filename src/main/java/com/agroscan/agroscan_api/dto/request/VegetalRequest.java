package com.agroscan.agroscan_api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record VegetalRequest(

        @NotBlank(message = "O nome comum é obrigatório.")
        @Size(max = 100, message = "O nome comum deve ter no máximo 100 caracteres.")
        String nomeComum,

        @Size(max = 120, message = "O nome científico deve ter no máximo 120 caracteres.")
        String nomeCientifico,

        @Size(max = 100, message = "A família botânica deve ter no máximo 100 caracteres.")
        String familiaBotanica,

        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
        String descricao,

        @Min(value = 1, message = "O ciclo de crescimento deve ser maior que zero.")
        Integer cicloCrescimentoDias
) {
}