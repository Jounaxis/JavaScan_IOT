package com.agroscan.agroscan_api.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioAppRequest(

        @NotBlank(message = "O nome é obrigatório.")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
        @Pattern(
                regexp = "^[A-Za-zÀ-ÿ\\s]+$",
                message = "O nome deve conter apenas letras e espaços."
        )
        String nome,

        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Informe um e-mail válido.")
        @Pattern(
                regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "O e-mail deve estar em um formato válido."
        )
        String email,

        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 8, max = 30, message = "A senha deve ter entre 8 e 30 caracteres.")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,30}$",
                message = "A senha deve conter letra maiúscula, letra minúscula e número."
        )
        String senha
) {
}
