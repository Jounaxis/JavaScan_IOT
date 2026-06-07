package com.agroscan.agroscan_api.dto.response;

import java.time.LocalDateTime;

public record UsuarioAppResponse(
        Long id,
        String nome,
        String email,
        LocalDateTime dataCadastro
) {
}