package com.spring_segurancadev.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
		
		@NotBlank(message = "Nome é obrigatório.")
		String nome,
		
		@NotBlank(message = "Email é obrigatório.")
		String email,
		
		@NotBlank(message = "Senha é obrigatória.")
		String senha
		
		) {

}
