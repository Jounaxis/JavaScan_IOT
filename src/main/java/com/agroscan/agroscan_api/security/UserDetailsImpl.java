package com.agroscan.agroscan_api.security;

import com.agroscan.agroscan_api.model.UsuarioApp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final UsuarioApp usuario;

    public UserDetailsImpl(UsuarioApp usuario) {
        this.usuario = usuario;
    }

    public UsuarioApp getUsuario() {
        return usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }
}