package com.agroscan.agroscan_api.service;


import com.agroscan.agroscan_api.dto.request.SimulacaoCultivoRequest;
import com.agroscan.agroscan_api.dto.response.SimulacaoCultivoResponse;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.SimulacaoCultivoMapper;
import com.agroscan.agroscan_api.model.*;
import com.agroscan.agroscan_api.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoCultivoService {

    private final SimulacaoCultivoRepository simulacaoRepository;
    private final UsuarioAppRepository usuarioRepository;
    private final VegetalRepository vegetalRepository;
    private final SoloRepository soloRepository;
    private final ClimaAmbienteRepository climaRepository;
    private final CorpoCelesteRepository corpoCelesteRepository;

    public SimulacaoCultivoService(
            SimulacaoCultivoRepository simulacaoRepository,
            UsuarioAppRepository usuarioRepository,
            VegetalRepository vegetalRepository,
            SoloRepository soloRepository,
            ClimaAmbienteRepository climaRepository,
            CorpoCelesteRepository corpoCelesteRepository
    ) {
        this.simulacaoRepository = simulacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.vegetalRepository = vegetalRepository;
        this.soloRepository = soloRepository;
        this.climaRepository = climaRepository;
        this.corpoCelesteRepository = corpoCelesteRepository;
    }

    public String create(SimulacaoCultivoRequest request) {

        UsuarioApp usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        Vegetal vegetal = vegetalRepository.findById(request.vegetalId())
                .orElseThrow(() -> new ResourceNotFoundException("Vegetal não encontrado."));

        Solo solo = soloRepository.findById(request.soloId())
                .orElseThrow(() -> new ResourceNotFoundException("Solo não encontrado."));

        ClimaAmbiente clima = climaRepository.findById(request.climaId())
                .orElseThrow(() -> new ResourceNotFoundException("Clima não encontrado."));

        CorpoCeleste corpoCeleste = corpoCelesteRepository.findById(request.corpoCelesteId())
                .orElseThrow(() -> new ResourceNotFoundException("Corpo celeste não encontrado."));

        SimulacaoCultivo simulacao = new SimulacaoCultivo();

        simulacao.setUsuario(usuario);
        simulacao.setVegetal(vegetal);
        simulacao.setSolo(solo);
        simulacao.setClima(clima);
        simulacao.setCorpoCeleste(corpoCeleste);
        simulacao.setScoreViabilidade(request.scoreViabilidade());

        if (request.scoreViabilidade() >= 70) {
            simulacao.setStatus("Viável");
            simulacao.setResultado("Cultivo recomendado.");
        } else if (request.scoreViabilidade() >= 40) {
            simulacao.setStatus("Parcialmente viável");
            simulacao.setResultado("Cultivo possível, mas exige ajustes.");
        } else {
            simulacao.setStatus("Não viável");
            simulacao.setResultado("Cultivo não recomendado.");
        }

        simulacaoRepository.save(simulacao);

        return "Simulação de cultivo cadastrada com sucesso.";
    }

    public List<SimulacaoCultivo> findAll() {
        return simulacaoRepository.findAll();
    }

    public SimulacaoCultivoResponse findById(Long id) {

        SimulacaoCultivo simulacao = simulacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Simulação não encontrada."));

        return SimulacaoCultivoMapper.toResponse(simulacao);
    }

    public String update(Long id, SimulacaoCultivoRequest request) {

        SimulacaoCultivo simulacao = simulacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Simulação não encontrada."));

        UsuarioApp usuario = usuarioRepository.findById(request.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

        Vegetal vegetal = vegetalRepository.findById(request.vegetalId())
                .orElseThrow(() -> new ResourceNotFoundException("Vegetal não encontrado."));

        Solo solo = soloRepository.findById(request.soloId())
                .orElseThrow(() -> new ResourceNotFoundException("Solo não encontrado."));

        ClimaAmbiente clima = climaRepository.findById(request.climaId())
                .orElseThrow(() -> new ResourceNotFoundException("Clima não encontrado."));

        CorpoCeleste corpoCeleste = corpoCelesteRepository.findById(request.corpoCelesteId())
                .orElseThrow(() -> new ResourceNotFoundException("Corpo celeste não encontrado."));

        simulacao.setUsuario(usuario);
        simulacao.setVegetal(vegetal);
        simulacao.setSolo(solo);
        simulacao.setClima(clima);
        simulacao.setCorpoCeleste(corpoCeleste);
        simulacao.setScoreViabilidade(request.scoreViabilidade());

        if (request.scoreViabilidade() >= 70) {
            simulacao.setStatus("Viável");
            simulacao.setResultado("Cultivo recomendado.");
        } else if (request.scoreViabilidade() >= 40) {
            simulacao.setStatus("Parcialmente viável");
            simulacao.setResultado("Cultivo possível, mas exige ajustes.");
        } else {
            simulacao.setStatus("Não viável");
            simulacao.setResultado("Cultivo não recomendado.");
        }

        simulacaoRepository.save(simulacao);

        return "Simulação de cultivo atualizada com sucesso.";
    }

    public String delete(Long id) {

        SimulacaoCultivo simulacao = simulacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Simulação não encontrada."));

        simulacaoRepository.delete(simulacao);

        return "Simulação de cultivo removida com sucesso.";
    }
}