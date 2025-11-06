package com.spring_segurancadev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_segurancadev.config.TokenConfig;
import com.spring_segurancadev.dto.request.LoginRequest;
import com.spring_segurancadev.dto.request.UsuarioRequest;
import com.spring_segurancadev.dto.response.LoginResponse;
import com.spring_segurancadev.dto.response.UsuarioResponse;
import com.spring_segurancadev.entity.Usuario;
import com.spring_segurancadev.repository.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final UsuarioRepository usuarioRep;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authManager;
	private final TokenConfig tokenConfig;
	

	public AuthController(UsuarioRepository usuarioRep, PasswordEncoder passwordEncoder, AuthenticationManager authManager, TokenConfig tokenConfig) {
		this.usuarioRep = usuarioRep;
		this.passwordEncoder = passwordEncoder;
		this.authManager = authManager;
		this.tokenConfig = tokenConfig;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
		
		UsernamePasswordAuthenticationToken userAndPass = 
					new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
		
		Authentication auth = authManager.authenticate(userAndPass);
		
		Usuario usuario = (Usuario) auth.getPrincipal();
		String token = tokenConfig.gerarToken(usuario);
		
		return ResponseEntity.ok(new LoginResponse(token));
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<UsuarioResponse> registroUsuario(@RequestBody @Valid UsuarioRequest usuarioRequest) {
		Usuario usuarioBd = new Usuario();
		
		usuarioBd.setNome(usuarioRequest.nome());
		usuarioBd.setEmail(usuarioRequest.email());
		usuarioBd.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
		
		usuarioRep.save(usuarioBd);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new UsuarioResponse(usuarioBd.getNome(), usuarioBd.getEmail()));
	}
	
}
