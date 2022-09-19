package com.youthcon21.event.haha.user.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class UserSenderEvent extends ApplicationEvent {

	private final String email;

	public UserSenderEvent(final Object source, final String email) {
		super(source);
		this.email = email;
	}
}
