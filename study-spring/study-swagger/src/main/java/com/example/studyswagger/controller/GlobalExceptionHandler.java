package com.example.studyswagger.controller;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ApiResponse(description = "bad request response")
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RuntimeException.class)
	public GlobalErrorResponse handleRuntimeException(Exception e) {
		GlobalErrorResponse response = new GlobalErrorResponse();
		response.errors.body = List.of(e.getMessage());

		return response;
	}

	@Data
	static class GlobalErrorResponse {

		@Schema(required = true)
		Errors errors;

		@Data
		@Schema(hidden = true)
		static class Errors {

			@Schema(required = true)
			List<String> body;
		}
	}
}
