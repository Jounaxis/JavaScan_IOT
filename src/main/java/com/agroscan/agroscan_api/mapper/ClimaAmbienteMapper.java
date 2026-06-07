package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.ClimaAmbienteRequest;
import com.agroscan.agroscan_api.dto.response.ClimaAmbienteResponse;
import com.agroscan.agroscan_api.model.ClimaAmbiente;

public class ClimaAmbienteMapper {

    public static ClimaAmbiente toEntity(ClimaAmbienteRequest request) {
        ClimaAmbiente clima = new ClimaAmbiente();

        clima.setTempMin(request.tempMin());
        clima.setTempMax(request.tempMax());
        clima.setNivelLuz(request.nivelLuz());
        clima.setNivelAgua(request.nivelAgua());
        clima.setNivelVento(request.nivelVento());
        clima.setDescricaoGeral(request.descricaoGeral());

        return clima;
    }

    public static ClimaAmbienteResponse toResponse(ClimaAmbiente clima) {
        return new ClimaAmbienteResponse(
                clima.getId(),
                clima.getTempMin(),
                clima.getTempMax(),
                clima.getNivelLuz(),
                clima.getNivelAgua(),
                clima.getNivelVento(),
                clima.getDescricaoGeral()
        );
    }
}