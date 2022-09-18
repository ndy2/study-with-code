package lec10_inheritance.javacode;

public interface Swimable {

	default void act() {
		System.out.println("어푸 어푸");
	}
}
