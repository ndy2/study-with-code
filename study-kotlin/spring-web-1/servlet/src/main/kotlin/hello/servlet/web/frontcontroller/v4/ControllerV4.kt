package hello.servlet.web.frontcontroller.v4

interface ControllerV4 {

    fun proc(model: MutableMap<String, Any>): String
}