package com.youthcon21.event.haha.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youthcon21.event.haha.admin.CouponService;
import com.youthcon21.event.haha.sender.SenderService;
import com.youthcon21.event.haha.user.domain.User;
import com.youthcon21.event.haha.user.peristence.UserRepository;
import com.youthcon21.event.haha.user.service.dto.UserDetailedResponse;
import com.youthcon21.event.haha.user.service.dto.UserRegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final SenderService senderService;
	private final CouponService couponService;

	@Transactional
	@Override
	public void registerUser(final UserRegisterRequest request) {
		User user = new User(
			request.getEmail(),
			request.getPassword()
		);
		userRepository.save(user);

		senderService.sendEmail(user.getEmail());
		couponService.register(user.getEmail());
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
