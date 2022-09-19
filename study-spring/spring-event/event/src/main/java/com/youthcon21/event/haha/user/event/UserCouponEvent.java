package com.youthcon21.event.haha.user.event;

import lombok.Getter;

@Getter
public class UserCouponEvent {

	private final String email;

	public UserCouponEvent(final String email) {
		this.email = email;
	}
}
