package com.youthcon21.event.haha.admin;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.youthcon21.event.haha.user.event.UserCouponEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserCouponEventListener {

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void onApplicationEvent(final UserCouponEvent event) {
		log.info("register user email : {}", event.getEmail());
	}
}
