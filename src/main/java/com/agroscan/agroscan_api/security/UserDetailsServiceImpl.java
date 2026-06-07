package com.agroscan.agroscan_api.security;

import com.agroscan.agroscan_api.model.UsuarioApp;
import com.agroscan.agroscan_api.repository.UsuarioAppRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioAppRepository repository;

    public UserDetailsServiceImpl(UsuarioAppRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioApp usuario = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        return new UserDetailsImpl(usuario);
    }
}