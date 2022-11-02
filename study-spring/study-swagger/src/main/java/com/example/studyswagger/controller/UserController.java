package com.example.studyswagger.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

		@NotNull
		@Size(min = 4, max = 20)
		@Schema(description = "유저이름", example = "haha", required = true)
		String username;

		@Email
		@NotNull
		@Schema(description = "이메일", example = "haha@papa.com", required = true)
		String email;

		@NotNull
		@Schema(description = "비밀번호", example = "p@ssw0rd", required = true)
		String password;
	}

	@Data
	@AllArgsConstructor
	static class NewUserResponse {
		@Schema(description = "유저이름", example = "haha", required = true)
		String username;

		@Schema(description = "이메일", example = "haha@papa.com", required = true)
		String email;

		@Schema(description = "자기소개", example = "Hello! I am haha", required = true)
		String bio;

		@Schema(description = "이미지", example = "haha.png", required = true)
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
	@GeneralApiResponses
	@PostMapping
	public NewUserResponse register(
			@Valid @RequestBody NewUserRequest request
	) {
		return new NewUserResponse(
				request.username,
				request.email,
				"Hello. It is REALWORLD",
				"realworld.png"
		);
	}
}
