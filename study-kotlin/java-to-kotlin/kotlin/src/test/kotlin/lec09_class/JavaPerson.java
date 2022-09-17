package lec09_class;

public class JavaPerson {

	private final String name;
	private int age;

	public JavaPerson(final String name) {
		this(name, 1);
	}

	public JavaPerson(final String name, final int age) {
		if (age < 0) {
			throw new IllegalArgumentException("age is negative");
		}

		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}
}
