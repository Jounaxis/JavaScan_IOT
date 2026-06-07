package com.agroscan.agroscan_api.dto.request;


import jakarta.validation.constraints.Positive;

public record RequisitoVegetalRequest(

        @Positive
        Double tempMin,

        @Positive
        Double tempMax,

        @Positive
        Double phSoloMin,

        @Positive
        Double phSoloMax,

        @Positive
        Double quantidadeAgua,

        @Positive
        Double nivelLuzMin,

        String notasCultivo
) {
}