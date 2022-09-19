package com.youthcon21.event.haha.user.service;

import com.youthcon21.event.haha.user.service.dto.UserDetailedResponse;
import com.youthcon21.event.haha.user.service.dto.UserRegisterRequest;

public interface UserService {

	void registerUser(UserRegisterRequest request);

	UserDetailedResponse getByEmail(String email);
}
