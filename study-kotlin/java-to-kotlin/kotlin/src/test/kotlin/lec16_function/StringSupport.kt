package lec16_function

// this : 수신 객체
// String : 수신 객체 타입
fun String.lastChar(): Char {

    return this[this.length - 1]
}