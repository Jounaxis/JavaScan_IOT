package com.agroscan.agroscan_api.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO_APP")
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioApp extends EntidadeBase {

    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 120)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @OneToMany(mappedBy = "usuario")
    private List<SimulacaoCultivo> simulacoes;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<SimulacaoCultivo> getSimulacoes() {
        return simulacoes;
    }

    public void setSimulacoes(List<SimulacaoCultivo> simulacoes) {
        this.simulacoes = simulacoes;
    }
}