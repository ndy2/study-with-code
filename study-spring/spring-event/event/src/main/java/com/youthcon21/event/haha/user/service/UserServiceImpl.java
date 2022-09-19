package com.youthcon21.event.haha.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youthcon21.event.haha.user.domain.User;
import com.youthcon21.event.haha.user.peristence.UserRepository;
import com.youthcon21.event.haha.user.service.dto.UserDetailedResponse;
import com.youthcon21.event.haha.user.service.dto.UserRegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void registerUser(final UserRegisterRequest request) {
		userRepository.save(new User(
			request.getEmail(),
			request.getPassword()
		));
	}

	@Override
	public UserDetailedResponse getByEmail(final String email) {
		final User user = userRepository.findByEmail(email);

		return new UserDetailedResponse(
			user.getId(),
			user.getEmail(),
			user.getPassword()
		);
	}
}
