package br.audora.log.exception;

public class ParametersException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParametersException(String mensagem) {
		super(mensagem);
	}

}