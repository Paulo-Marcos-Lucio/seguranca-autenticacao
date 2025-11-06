package com.spring_segurancadev.config;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring_segurancadev.entity.Usuario;

@Component
public class TokenConfig {

	private String secret = "secret";
	
	Algorithm algorithm = Algorithm.HMAC256(secret);
	
	public String gerarToken(Usuario usuario) {
		return JWT.create()
				.withClaim("usuarioId", usuario.getId())
				.withSubject(usuario.getEmail())
				.withExpiresAt(Instant.now().plusSeconds(86400))
				.withIssuedAt(Instant.now())
				.sign(algorithm);
				
		
	}
}
