package support;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.ConstructorPropertiesArbitraryGenerator;

public class BaseTest {

	protected static FixtureMonkey fixture = FixtureMonkey.builder()
		.defaultGenerator(ConstructorPropertiesArbitraryGenerator.INSTANCE)
		.build();

	protected ArbitraryBuilder<String> arbitraryBuilderString() {
		return fixture.giveMeBuilder(String.class);
	}
}
