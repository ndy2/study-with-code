package lec09_class

/*
* 이름은 바꿀 수 없다
* kotlin 에서는 field 만 만들면 getter, setter 를 자동으로 만들어 준다
* constructor 생략 가능
* */
class Person1 constructor(
    name: String,
    age: Int
) {

    val name: String = name
    var age: Int = age
}