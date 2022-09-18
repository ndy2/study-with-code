package lec12_object.javacode;

public class Person {
	private static final int MIN_AGE = 1;

	private final String name;
	private final int age;

	public Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}


	private static Person newBaby(String name){
		return new Person(name, MIN_AGE);
	}
}
