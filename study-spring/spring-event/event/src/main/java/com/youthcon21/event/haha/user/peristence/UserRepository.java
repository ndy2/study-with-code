package com.youthcon21.event.haha.user.peristence;

import org.springframework.data.repository.CrudRepository;

import com.youthcon21.event.haha.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
}
