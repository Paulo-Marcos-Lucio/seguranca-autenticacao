package com.spring_segurancadev.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_segurancadev.repository.UsuarioRepository;

@Service
public class AuthConfig implements UserDetailsService {
	
	private final UsuarioRepository usuarioRep;
	

	public AuthConfig(UsuarioRepository usuarioRep) {
		this.usuarioRep = usuarioRep;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioRep.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
	
	
	
	
	
	
	

}
