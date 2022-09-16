package lec03_type;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TypeTest_Java {

	int getAgeIfHaha_java(Object target) {
		if (target instanceof Haha_Java) {
			Haha_Java haha = (Haha_Java)target;
			return haha.age;
		} else {
			throw new IllegalArgumentException("no haha");
		}
	}

	@Test
	void haha_test() {
		assertThat(getAgeIfHaha_java(new Haha_Java())).isEqualTo(26);
		assertThatIllegalArgumentException()
			.isThrownBy(() -> getAgeIfHaha_java("not haha"));
	}
}
