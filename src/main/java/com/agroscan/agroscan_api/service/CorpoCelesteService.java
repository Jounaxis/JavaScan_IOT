package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.CorpoCelesteRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.CorpoCelesteMapper;
import com.agroscan.agroscan_api.model.CorpoCeleste;
import com.agroscan.agroscan_api.repository.CorpoCelesteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorpoCelesteService {

    private final CorpoCelesteRepository repository;

    public CorpoCelesteService(CorpoCelesteRepository repository) {
        this.repository = repository;
    }

    public String create(CorpoCelesteRequest request) {
        repository.save(CorpoCelesteMapper.toEntity(request));
        return "Corpo celeste cadastrado com sucesso.";
    }

    public List<CorpoCeleste> findAll() {
        return repository.findAll();
    }

    public CorpoCeleste findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Corpo celeste não encontrado."));
    }

    public String update(Long id, CorpoCelesteRequest request) {
        CorpoCeleste corpo = findById(id);

        corpo.setNome(request.nome());
        corpo.setTipo(request.tipo());
        corpo.setGravidadeMs2(request.gravidadeMs2());
        corpo.setTemperaturaMedia(request.temperaturaMedia());
        corpo.setComposicaoAtmosfera(request.composicaoAtmosfera());
        corpo.setDescricao(request.descricao());

        repository.save(corpo);
        return "Corpo celeste atualizado com sucesso.";
    }

    public String delete(Long id) {
        repository.delete(findById(id));
        return "Corpo celeste removido com sucesso.";
    }
}