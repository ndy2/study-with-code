package domain.user;

import static org.assertj.core.api.Assertions.*;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Property;

import domain.user.Email;
import support.domain.BaseDomainTest;

class EmailTest extends BaseDomainTest {

	@Property
	void 이메일_생성_성공_emailArbitrary() {
		//when
		Email actual = emailArbitrary().sample();

		//then
		assertThat(actual).isNotNull();
	}

	@Property
	void 이메일_생성_실패_null() {
		assertThatNullPointerException()
			.isThrownBy(() -> fixture.giveMeBuilder(Email.class).setNull("value").sample());
	}

	@Property
	void 이메일_형식_실패_아무렇게나_넣으면() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> fixture.giveMeBuilder(Email.class).set("value", Arbitraries.strings()).sample());
	}

}