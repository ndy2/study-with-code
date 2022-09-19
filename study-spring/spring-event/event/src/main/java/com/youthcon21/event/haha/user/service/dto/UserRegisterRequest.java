package com.youthcon21.event.haha.user.service.dto;

import lombok.Data;
import lombok.Value;

@Value
public class UserRegisterRequest {

	String email;
	String password;
}
