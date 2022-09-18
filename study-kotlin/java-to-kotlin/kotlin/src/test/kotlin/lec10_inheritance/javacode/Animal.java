package lec10_inheritance.javacode;

public abstract class Animal {

	protected final String species;
	protected final int legCount;

	public Animal(final String species, final int legCount) {
		this.species = species;
		this.legCount = legCount;
	}

	abstract public void move();

	public String getSpecies() {
		return species;
	}

	public int getLegCount() {
		return legCount;
	}
}
