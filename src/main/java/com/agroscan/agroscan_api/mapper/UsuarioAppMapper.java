package com.agroscan.agroscan_api.mapper;

import com.agroscan.agroscan_api.dto.request.UsuarioAppRequest;
import com.agroscan.agroscan_api.dto.response.UsuarioAppResponse;
import com.agroscan.agroscan_api.model.UsuarioApp;

public class UsuarioAppMapper {

    public static UsuarioApp toEntity(UsuarioAppRequest request) {

        UsuarioApp usuario = new UsuarioApp();

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(request.senha());

        return usuario;
    }

    public static UsuarioAppResponse toResponse(UsuarioApp usuario) {

        return new UsuarioAppResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataCadastro()
        );
    }
}