package lec10_inheritance.javacode;

public class Cat extends Animal {
	public Cat(final String species) {
		super(species, 4);
	}

	@Override
	public void move() {
		System.out.println("고양 고양 고양 고양");
	}
}
