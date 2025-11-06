package com.spring_segurancadev.exception;

public class NomeDeUsuarioNaoEncontradoException extends NegocioException {


	private static final long serialVersionUID = 1L;

	public NomeDeUsuarioNaoEncontradoException(String msg) {
		super("Nome desse usuário nao foi encontrado.");
	}

}
