package com.youthcon21.event.haha.admin;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

	@Override
	public void register(final String email) {

		log.info("register user email : {}", email);
	}
}
