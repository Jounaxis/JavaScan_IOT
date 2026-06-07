package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.RequisitoVegetalRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.mapper.RequisitoVegetalMapper;
import com.agroscan.agroscan_api.model.RequisitoVegetal;
import com.agroscan.agroscan_api.repository.RequisitoVegetalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisitoVegetalService {

    private final RequisitoVegetalRepository repository;

    public RequisitoVegetalService(RequisitoVegetalRepository repository) {
        this.repository = repository;
    }

    public String create(RequisitoVegetalRequest request) {
        repository.save(RequisitoVegetalMapper.toEntity(request));
        return "Requisito vegetal cadastrado com sucesso.";
    }

    public List<RequisitoVegetal> findAll() {
        return repository.findAll();
    }

    public RequisitoVegetal findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Requisito vegetal não encontrado."));
    }

    public String update(Long id, RequisitoVegetalRequest request) {
        RequisitoVegetal requisito = findById(id);

        requisito.setTempMin(request.tempMin());
        requisito.setTempMax(request.tempMax());
        requisito.setPhSoloMin(request.phSoloMin());
        requisito.setPhSoloMax(request.phSoloMax());
        requisito.setQuantidadeAgua(request.quantidadeAgua());
        requisito.setNivelLuzMin(request.nivelLuzMin());
        requisito.setNotasCultivo(request.notasCultivo());

        repository.save(requisito);
        return "Requisito vegetal atualizado com sucesso.";
    }

    public String delete(Long id) {
        repository.delete(findById(id));
        return "Requisito vegetal removido com sucesso.";
    }
}