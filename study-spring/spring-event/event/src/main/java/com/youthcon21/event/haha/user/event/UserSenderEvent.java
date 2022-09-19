package com.youthcon21.event.haha.user.event;

import lombok.Getter;

@Getter
public class UserSenderEvent {

	private final String email;

	public UserSenderEvent(final String email) {
		this.email = email;
	}
}
