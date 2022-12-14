package com.youthcon21.event.haha.user.domain;

import static lombok.AccessLevel.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.ApplicationEventPublisher;

import com.youthcon21.event.haha.user.event.UserCouponEvent;
import com.youthcon21.event.haha.user.event.UserSenderEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String password;

	public User(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

	public void registerEvent(final ApplicationEventPublisher eventPublisher) {
		eventPublisher.publishEvent(new UserCouponEvent(this.email));
		eventPublisher.publishEvent(new UserSenderEvent(this.email));
	}
}
