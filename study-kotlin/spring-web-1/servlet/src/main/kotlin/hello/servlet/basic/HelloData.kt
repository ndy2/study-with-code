package hello.servlet.basic

import hello.servlet.annotation.NoArgs

@NoArgs
data class HelloData(
    var username: String,
    var age: Int,
)