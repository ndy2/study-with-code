package lec14_special_classes.javacode;

import java.util.Objects;
import java.util.StringJoiner;

// @Data
public class JavaPersonDto {

	private final String name;
	private final int age;

	public JavaPersonDto(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final JavaPersonDto that = (JavaPersonDto)o;
		return age == that.age && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", JavaPersonDto.class.getSimpleName() + "[", "]")
			.add("name='" + name + "'")
			.add("age=" + age)
			.toString();
	}
}


