package lec01_variable;

import org.junit.jupiter.api.Test;

public class Variable_Java {

	static class Person{
		String name;

		public Person(final String name) {
			this.name = name;
		}
	}

	@Test
	void variable() {
		long number1 = 10L;
		final long number2 = 10L;

		Long number3 = 1000L;
		Person person = new Person("남득윤");
	}
}
