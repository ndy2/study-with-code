package lec10_inheritance.javacode;

public class Penguin
	extends Animal
	implements Flyable, Swimable {

	private final int wingCount;

	public Penguin(final String species, final int legCount) {
		super(species, legCount);
		this.wingCount = 2;
	}

	@Override
	public void move() {
		System.out.println("펭귄 펭귄");
	}

	@Override
	public int getLegCount() {
		return super.getLegCount() + this.wingCount;
	}

	@Override
	public void act() {
		Swimable.super.act();
		Flyable.super.act();
	}

	@Override
	public void fly() {
		System.out.println("fly me to the moon");
	}
}
