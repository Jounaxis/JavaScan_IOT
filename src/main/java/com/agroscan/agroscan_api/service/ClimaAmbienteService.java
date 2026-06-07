package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.ClimaAmbienteRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.ClimaAmbienteMapper;
import com.agroscan.agroscan_api.model.ClimaAmbiente;
import com.agroscan.agroscan_api.repository.ClimaAmbienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClimaAmbienteService {

    private final ClimaAmbienteRepository repository;

    public ClimaAmbienteService(ClimaAmbienteRepository repository) {
        this.repository = repository;
    }

    public String create(ClimaAmbienteRequest request) {
        repository.save(ClimaAmbienteMapper.toEntity(request));
        return "Clima cadastrado com sucesso.";
    }

    public List<ClimaAmbiente> findAll() {
        return repository.findAll();
    }

    public ClimaAmbiente findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clima não encontrado."));
    }

    public String update(Long id, ClimaAmbienteRequest request) {
        ClimaAmbiente clima = findById(id);

        clima.setTempMin(request.tempMin());
        clima.setTempMax(request.tempMax());
        clima.setNivelLuz(request.nivelLuz());
        clima.setNivelAgua(request.nivelAgua());
        clima.setNivelVento(request.nivelVento());
        clima.setDescricaoGeral(request.descricaoGeral());

        repository.save(clima);
        return "Clima atualizado com sucesso.";
    }

    public String delete(Long id) {
        repository.delete(findById(id));
        return "Clima removido com sucesso.";
    }
}
