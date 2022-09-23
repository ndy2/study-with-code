package hello.servlet.web.frontcontroller.v5.adpater

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV3HandlerAdapter : MyHandlerAdapter {

    override fun support(handler: Any): Boolean {
        return handler is ControllerV3
    }

    override fun handle(req: HttpServletRequest, resp: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV3
        val paramMap = createParamMap(req)
        val modelView = controller.proc(paramMap)
        return modelView
    }


    private fun createParamMap(req: HttpServletRequest): MutableMap<String, String> {
        val paramMap: MutableMap<String, String> = mutableMapOf()
        req.parameterNames.asIterator()
            .forEachRemaining { paramName -> paramMap[paramName] = req.getParameter(paramName) }
        return paramMap
    }
}