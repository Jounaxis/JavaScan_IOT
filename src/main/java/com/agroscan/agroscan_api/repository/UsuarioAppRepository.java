package com.agroscan.agroscan_api.repository;

import com.agroscan.agroscan_api.model.UsuarioApp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioAppRepository extends JpaRepository<UsuarioApp, Long> {
    Optional<UsuarioApp> findByEmail(String email);
}