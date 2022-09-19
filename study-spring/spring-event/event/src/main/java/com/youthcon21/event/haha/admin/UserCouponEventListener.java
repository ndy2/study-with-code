package com.youthcon21.event.haha.admin;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.youthcon21.event.haha.user.event.UserCouponEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCouponEventListener implements ApplicationListener<UserCouponEvent> {

	@Override
	public void onApplicationEvent(final UserCouponEvent event) {
		log.info("register user email : {}", event.getEmail());
	}
}
