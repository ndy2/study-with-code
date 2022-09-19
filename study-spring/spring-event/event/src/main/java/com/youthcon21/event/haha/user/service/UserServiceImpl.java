package com.youthcon21.event.haha.user.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youthcon21.event.haha.user.domain.User;
import com.youthcon21.event.haha.user.peristence.UserRepository;
import com.youthcon21.event.haha.user.service.dto.UserDetailedResponse;
import com.youthcon21.event.haha.user.service.dto.UserRegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	// domain service !!
	private final ApplicationEventPublisher eventPublisher;

	@Transactional
	@Override
	public void registerUser(final UserRegisterRequest request) {
		User user = new User(
			request.getEmail(),
			request.getPassword()
		);
		userRepository.save(user);

		user.registerEvent(eventPublisher);
	}

	@Transactional(readOnly = true)
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
