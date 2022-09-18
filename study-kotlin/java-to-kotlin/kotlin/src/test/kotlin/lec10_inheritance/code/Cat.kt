package lec10_inheritance.code

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양 고양 고양 고양")
    }
}