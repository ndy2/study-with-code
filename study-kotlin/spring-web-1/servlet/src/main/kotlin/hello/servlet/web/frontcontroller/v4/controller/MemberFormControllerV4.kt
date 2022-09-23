package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberFormControllerV4 : ControllerV4 {

    override fun proc(model: MutableMap<String, Any>): String {
        return "new-form"
    }
}