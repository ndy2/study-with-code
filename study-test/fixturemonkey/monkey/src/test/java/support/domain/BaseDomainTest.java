package support.domain;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;

import domain.user.Email;
import domain.user.OAuthType;
import support.BaseTest;

import com.navercorp.fixturemonkey.ArbitraryBuilders;

public class BaseDomainTest extends BaseTest {

	protected Arbitrary<OAuthType> oauthTypeArbitrary() {
		return fixture.giveMeArbitrary(OAuthType.class);
	}

	protected Arbitrary<Email> emailArbitrary() {
		Arbitrary<String> emailArbitrary = ArbitraryBuilders.zip(
			arbitraryBuilderString().set(Arbitraries.strings().alpha().numeric().ofMinLength(3).ofMaxLength(10)),
			arbitraryBuilderString().set(Arbitraries.strings().alpha().numeric().ofMinLength(3).ofMaxLength(10)),
			arbitraryBuilderString().set(Arbitraries.strings().alpha().numeric().ofMinLength(3).ofMaxLength(5)),
			(username, mailService, domain) -> username + "@" + mailService + "." + domain
		).build();

		return fixture.giveMeBuilder(Email.class)
			.set("value", emailArbitrary)
			.build();
	}
}
