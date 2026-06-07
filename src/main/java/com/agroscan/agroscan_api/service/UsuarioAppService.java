package com.agroscan.agroscan_api.service;

import com.agroscan.agroscan_api.dto.request.UsuarioAppRequest;
import com.agroscan.agroscan_api.exception.ResourceNotFoundException;
import com.agroscan.agroscan_api.model.UsuarioApp;
import com.agroscan.agroscan_api.repository.UsuarioAppRepository;
import com.agroscan.agroscan_api.mapper.UsuarioAppMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioAppService {

    private final UsuarioAppRepository repository;

    public UsuarioAppService(UsuarioAppRepository repository) {
        this.repository = repository;
    }

    public String create(UsuarioAppRequest request) {
        UsuarioApp usuario = UsuarioAppMapper.toEntity(request);
        repository.save(usuario);
        return "Usuário cadastrado com sucesso.";
    }

    public List<UsuarioApp> findAll() {
        return repository.findAll();
    }

    public UsuarioApp findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
    }

    public String update(Long id, UsuarioAppRequest request) {
        UsuarioApp usuario = findById(id);

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());

        repository.save(usuario);

        return "Usuário atualizado com sucesso.";
    }

    public String delete(Long id) {
        UsuarioApp usuario = findById(id);
        repository.delete(usuario);
        return "Usuário removido com sucesso.";
    }
}