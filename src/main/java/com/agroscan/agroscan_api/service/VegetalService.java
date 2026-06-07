package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.VegetalRequest;
import com.agroscan.agroscan_api.mapper.VegetalMapper;
import com.agroscan.agroscan_api.model.Vegetal;
import com.agroscan.agroscan_api.repository.VegetalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetalService {

    private final VegetalRepository repository;

    public VegetalService(VegetalRepository repository) {
        this.repository = repository;
    }

    public String create(VegetalRequest request) {
        Vegetal vegetal = VegetalMapper.toEntity(request);
        repository.save(vegetal);
        return "Vegetal cadastrado com sucesso.";
    }

    public List<Vegetal> findAll() {
        return repository.findAll();
    }

    public Vegetal findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vegetal não encontrado."));
    }

    public String update(Long id, VegetalRequest request) {
        Vegetal vegetal = findById(id);

        vegetal.setNomeComum(request.nomeComum());
        vegetal.setNomeCientifico(request.nomeCientifico());
        vegetal.setFamiliaBotanica(request.familiaBotanica());
        vegetal.setDescricao(request.descricao());
        vegetal.setCicloCrescimentoDias(request.cicloCrescimentoDias());

        repository.save(vegetal);

        return "Vegetal atualizado com sucesso.";
    }

    public String delete(Long id) {
        Vegetal vegetal = findById(id);
        repository.delete(vegetal);
        return "Vegetal removido com sucesso.";
    }
}