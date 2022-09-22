package hello.servlet.domain.member

import hello.servlet.annotation.NoArgs

@NoArgs
class Member(
    val username: String,
    val age: Int,
) {
    var id: Long = 0
}