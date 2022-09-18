package domain;

import static org.assertj.core.api.Assertions.*;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Size;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.ConstructorPropertiesArbitraryGenerator;

class EmailTest {

	static FixtureMonkey fixture = FixtureMonkey.builder()
		.nullInject(0.0) // 의도 하지 않는 null 주입 끄기
		.defaultGenerator(ConstructorPropertiesArbitraryGenerator.INSTANCE)
		.build();


	@Property
	void 이메일_생성_성공(
		@ForAll
		@net.jqwik.api.constraints.Email(ipv4Host = false,
			ipv6Host = false,
			quotedLocalPart = false
		)
		@Size(max = 255) String value) {

		//when
		Email email = new Email(value);

		//then
		assertThat(email).isNotNull();
		assertThat(email.getValue()).contains("@");
	}

	@Property
	void 이메일_생성_성공_항상_하하() {
		//when
		Email actual = fixture.giveMeBuilder(Email.class)
			.set("value", "haha@gmail.com")
			.sample();

		//then
		assertThat(actual).isNotNull();
	}

	@Property
	void 이메일_생성_실패_null() {
		assertThatNullPointerException().isThrownBy(() ->
			fixture.giveMeBuilder(Email.class)
				.setNull("value")
				.sample());
	}

	@Property
	void 이메일_형식_실패_아무렇게나_넣으면() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			fixture.giveMeBuilder(Email.class)
				.sample());
	}


}