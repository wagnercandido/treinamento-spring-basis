package com.basis.cg.xtarefas.service.exception;

public class ParametrizedException extends RuntimeException {

	public ParametrizedException(String msg) {
		super(msg);
	}

	public ParametrizedException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
