package com.agroscan.agroscan_api.controller;

import com.agroscan.agroscan_api.dto.request.LoginRequest;
import com.agroscan.agroscan_api.dto.response.LoginResponse;
import com.agroscan.agroscan_api.model.UsuarioApp;
import com.agroscan.agroscan_api.repository.UsuarioAppRepository;
import com.agroscan.agroscan_api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioAppRepository repository;
    private final TokenService tokenService;

    public AuthController(UsuarioAppRepository repository, TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {

        UsuarioApp usuario = repository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (!usuario.getSenha().equals(request.senha())) {
            throw new RuntimeException("Senha inválida.");
        }

        String token = tokenService.gerarToken(usuario);

        return new LoginResponse(token);
    }
}