package com.youthcon21.event.haha.sender;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.youthcon21.event.haha.user.event.UserSenderEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserSenderEventListener{

	@EventListener
	@Async
	public void onApplicationEvent(final UserSenderEvent event) {
		log.info("send email to {}", event.getEmail());
	}
}
