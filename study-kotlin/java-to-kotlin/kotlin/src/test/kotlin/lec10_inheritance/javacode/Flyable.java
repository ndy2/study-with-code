package lec10_inheritance.javacode;

public interface Flyable {

	default void act() {
		System.out.println("파닥 파닥");
	}

	void fly();
}
