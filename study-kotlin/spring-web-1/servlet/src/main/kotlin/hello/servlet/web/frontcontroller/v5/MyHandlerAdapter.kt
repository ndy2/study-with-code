package hello.servlet.web.frontcontroller.v5

import hello.servlet.web.frontcontroller.ModelView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

interface MyHandlerAdapter {

    fun support(handler: Any): Boolean
    fun handle(req: HttpServletRequest, resp: HttpServletResponse, handler: Any): ModelView
}