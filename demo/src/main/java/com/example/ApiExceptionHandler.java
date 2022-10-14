package com.example;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exceptions.BadRequestException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import feign.FeignException;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice
public class ApiExceptionHandler {
	public static class ErrorMessage implements Serializable {
		private static final long serialVersionUID = 1L;
		private String error, message;

		public ErrorMessage(String error, String message) {
			this.error = error;
			this.message = message;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundException.class, EmptyResultDataAccessException.class })
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage("Not found", request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BadRequestException.class, HttpMessageNotReadableException.class })
	public ErrorMessage badRequest(Exception exception) {
		return new ErrorMessage(exception.getMessage(), "");
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidDataException.class })
	public ErrorMessage invalidDataRequest(Exception exception) {
		return new ErrorMessage("Invalid data", exception.getMessage());
	}
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ErrorMessage methodNotSupported(Exception exception) {
		return new ErrorMessage(exception.getMessage(), "");
	}
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ AccessDeniedException.class, FeignException.Forbidden.class })
	public ErrorMessage accessDenied(Exception exception) {
		return new ErrorMessage("Access Denied", exception.getMessage());
	}
}
