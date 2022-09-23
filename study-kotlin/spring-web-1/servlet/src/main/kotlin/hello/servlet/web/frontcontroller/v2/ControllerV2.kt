package hello.servlet.web.frontcontroller.v2

import hello.servlet.web.frontcontroller.MyView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface ControllerV2 {

    fun proc(req: HttpServletRequest, resp: HttpServletResponse) : MyView
}