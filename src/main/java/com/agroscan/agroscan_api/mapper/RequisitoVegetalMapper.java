package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.RequisitoVegetalRequest;
import com.agroscan.agroscan_api.dto.response.RequisitoVegetalResponse;
import com.agroscan.agroscan_api.model.RequisitoVegetal;

public class RequisitoVegetalMapper {

    public static RequisitoVegetal toEntity(RequisitoVegetalRequest request) {
        RequisitoVegetal requisito = new RequisitoVegetal();

        requisito.setTempMin(request.tempMin());
        requisito.setTempMax(request.tempMax());
        requisito.setPhSoloMin(request.phSoloMin());
        requisito.setPhSoloMax(request.phSoloMax());
        requisito.setQuantidadeAgua(request.quantidadeAgua());
        requisito.setNivelLuzMin(request.nivelLuzMin());
        requisito.setNotasCultivo(request.notasCultivo());

        return requisito;
    }

    public static RequisitoVegetalResponse toResponse(RequisitoVegetal requisito) {
        return new RequisitoVegetalResponse(
                requisito.getId(),
                requisito.getTempMin(),
                requisito.getTempMax(),
                requisito.getPhSoloMin(),
                requisito.getPhSoloMax(),
                requisito.getQuantidadeAgua(),
                requisito.getNivelLuzMin(),
                requisito.getNotasCultivo()
        );
    }
}