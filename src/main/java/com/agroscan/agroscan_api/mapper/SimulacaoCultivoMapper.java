package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.response.SimulacaoCultivoResponse;
import com.agroscan.agroscan_api.model.SimulacaoCultivo;

public class SimulacaoCultivoMapper {

    public static SimulacaoCultivoResponse toResponse(SimulacaoCultivo simulacao) {
        return new SimulacaoCultivoResponse(
                simulacao.getId(),
                simulacao.getDataSimulacao(),
                simulacao.getStatus(),
                simulacao.getScoreViabilidade(),
                simulacao.getResultado()
        );
    }
}