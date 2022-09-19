package com.youthcon21.event.haha.user.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youthcon21.event.haha.user.service.UserService;
import com.youthcon21.event.haha.user.service.dto.UserDetailedResponse;
import com.youthcon21.event.haha.user.service.dto.UserRegisterRequest;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public void registerUser(
		@RequestBody UserRegisterRequest request
	) {
		userService.registerUser(request);
	}

	@GetMapping("/{email}")
	public UserDetailedResponse getDetailedUser(
		@PathVariable String email
	) {
		return userService.getByEmail(email);
	}

}
