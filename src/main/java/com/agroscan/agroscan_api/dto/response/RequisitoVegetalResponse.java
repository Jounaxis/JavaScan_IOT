package com.agroscan.agroscan_api.dto.response;

public record RequisitoVegetalResponse(
        Long id,
        Double tempMin,
        Double tempMax,
        Double phSoloMin,
        Double phSoloMax,
        Double quantidadeAgua,
        Double nivelLuzMin,
        String notasCultivo
) {
}