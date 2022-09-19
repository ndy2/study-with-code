package com.youthcon21.event.haha.sender;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SenderServiceImpl implements SenderService {

	@Override
	public void sendEmail(final String email) {

		log.info("send email to {}", email);
	}
}
