package com.spring_segurancadev.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
		
		@NotBlank(message = "Email é obrigatório.")
		String email,
		
		@NotBlank(message = "Senha é obrigatória.")
		String senha
		
		) {

}
