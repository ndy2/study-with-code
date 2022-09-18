package lec10_inheritance.code

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {
    private val wingCount = 2

    override fun move() {
        println("펭귄 펭귄")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        println("fly me to the moon")
    }

    override val swimAbility: Int
        get() = 3
}