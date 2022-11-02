package com.example.studyswagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User and Authentication")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Data
	static class NewUserRequest {

		@Schema(description = "유저이름")
		String username;

		@Schema(description = "이메일")
		String email;

		@Schema(description = "비밀번호")
		String password;
	}

	@Data
	@AllArgsConstructor
	static class NewUserResponse {
		String username;
		String email;
		String bio;
		String image;
	}

	@Operation(summary = "Register a new user", description = "Register a new user")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(
			description = "Details of the new user to register"
	)
	@ApiResponses(@ApiResponse(
			responseCode = "200",
			description = "OK",
			content = @Content(schema = @Schema(implementation = NewUserResponse.class))
	))
	@PostMapping
	public NewUserResponse register(
			@RequestBody NewUserRequest request
	) {
		return new NewUserResponse(
				request.username,
				request.email,
				"Hello. It is REALWORLD",
				"realworld.png"
		);
	}
}
