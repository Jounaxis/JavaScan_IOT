package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.SoloRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.SoloMapper;
import com.agroscan.agroscan_api.model.Solo;
import com.agroscan.agroscan_api.repository.SoloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoloService {

    private final SoloRepository repository;

    public SoloService(SoloRepository repository) {
        this.repository = repository;
    }

    public String create(SoloRequest request) {
        repository.save(SoloMapper.toEntity(request));
        return "Solo cadastrado com sucesso.";
    }

    public List<Solo> findAll() {
        return repository.findAll();
    }

    public Solo findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Solo não encontrado."));
    }

    public String update(Long id, SoloRequest request) {
        Solo solo = findById(id);

        solo.setTipoSolo(request.tipoSolo());
        solo.setPhEstimado(request.phEstimado());
        solo.setNivelNutrientes(request.nivelNutrientes());
        solo.setRetencaoAgua(request.retencaoAgua());
        solo.setComposicaoPrincipal(request.composicaoPrincipal());
        solo.setObservacoes(request.observacoes());

        repository.save(solo);
        return "Solo atualizado com sucesso.";
    }

    public String delete(Long id) {
        repository.delete(findById(id));
        return "Solo removido com sucesso.";
    }
}