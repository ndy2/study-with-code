package domain.user;

import static org.assertj.core.api.Assertions.*;

import net.jqwik.api.Property;

import domain.user.OAuthType;
import support.domain.BaseDomainTest;

class OAuthTypeTest extends BaseDomainTest {

	@Property
	void OAuthType_생성_성공() {
		//when
		OAuthType actual = fixture.giveMeOne(OAuthType.class);

		//then
		assertThat(actual).isNotNull();
	}

	@Property
	void OAuthType_Arbitrary_로_생성_성공() {
		//when
		OAuthType actual = oauthTypeArbitrary().sample();

		//then
		assertThat(actual).isNotNull();
	}

}