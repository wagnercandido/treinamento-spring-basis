package com.basis.cg.xtarefas.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.basis.cg.xtarefas.service.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageByLocaleService messageSource;

	@ExceptionHandler(ParametrizedException.class)
	public ResponseEntity<StandardError> negocioException(ParametrizedException e, HttpServletRequest request) {
		String title = messageSource.getMessage(ConstantsUtil.ERROR_TITLE);
		String msgError = messageSource.getMessage(e.getMessage());
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), title, msgError, request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
}
