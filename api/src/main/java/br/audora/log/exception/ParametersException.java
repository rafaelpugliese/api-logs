package br.audora.log.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParametersException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParametersException(String mensagem) {
		super(mensagem);
	}

	@Override
	@JsonIgnore
	public StackTraceElement[] getStackTrace() {
		return super.getStackTrace();
	}

	@Override
	@JsonIgnore
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}

}