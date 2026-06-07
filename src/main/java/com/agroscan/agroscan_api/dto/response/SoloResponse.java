package com.agroscan.agroscan_api.dto.response;

public record SoloResponse(
        Long id,
        String tipoSolo,
        Double phEstimado,
        String nivelNutrientes,
        Double retencaoAgua,
        String composicaoPrincipal,
        String observacoes
) {
}