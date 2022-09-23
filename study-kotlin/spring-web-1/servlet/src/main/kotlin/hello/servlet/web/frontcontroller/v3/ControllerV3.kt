package hello.servlet.web.frontcontroller.v3

import hello.servlet.web.frontcontroller.ModelView

interface ControllerV3 {

    fun proc(paramMap: Map<String, String>): ModelView
}