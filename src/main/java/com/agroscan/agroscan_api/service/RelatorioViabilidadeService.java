package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.RelatorioViabilidadeRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.RelatorioViabilidadeMapper;
import com.agroscan.agroscan_api.model.RelatorioViabilidade;
import com.agroscan.agroscan_api.repository.RelatorioViabilidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioViabilidadeService {

    private final RelatorioViabilidadeRepository repository;

    public RelatorioViabilidadeService(RelatorioViabilidadeRepository repository) {
        this.repository = repository;
    }

    public String create(RelatorioViabilidadeRequest request) {
        repository.save(RelatorioViabilidadeMapper.toEntity(request));
        return "Relatório de viabilidade cadastrado com sucesso.";
    }

    public List<RelatorioViabilidade> findAll() {
        return repository.findAll();
    }

    public RelatorioViabilidade findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatório de viabilidade não encontrado."));
    }

    public String update(Long id, RelatorioViabilidadeRequest request) {
        RelatorioViabilidade relatorio = findById(id);

        relatorio.setFatorAvaliado(request.fatorAvaliado());
        relatorio.setValorEncontrado(request.valorEncontrado());
        relatorio.setValorEsperado(request.valorEsperado());
        relatorio.setStatusFator(request.statusFator());
        relatorio.setRecomendacao(request.recomendacao());

        repository.save(relatorio);
        return "Relatório de viabilidade atualizado com sucesso.";
    }

    public String delete(Long id) {
        repository.delete(findById(id));
        return "Relatório de viabilidade removido com sucesso.";
    }
}