package lec14_special_classes.javacode

sealed class HyndaiCar(
    val name: String,
    val price: Long,
)

class Avante : HyndaiCar("아반떼", 1000)
class Sonata : HyndaiCar("소나타", 1000)
class Gradeur : HyndaiCar("그랜저", 1000)