package domain.user;

import static org.assertj.core.api.Assertions.*;

import net.jqwik.api.Property;

import support.domain.BaseDomainTest;

class UserTest extends BaseDomainTest {

	@Property
	void 사용자_생성_성공() {
		//when
		User user = fixture.giveMeBuilder(User.class)
			.set("email", emailArbitrary())
			.set("oAuthType", oauthTypeArbitrary())
			.sample();

		//then
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isNotNull();
		assertThat(user.getOAuthType()).isNotNull();
	}

	@Property
	void 사용자_생성_실패() {
		assertThatNullPointerException().isThrownBy(() ->
			fixture.giveMeBuilder(User.class)
				.setNull("email")
				.setNull("oAuthType")
				.sample());
	}
}