package hello.servlet.web.frontcontroller.v5.adpater

import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v4.ControllerV4
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ControllerV4HandlerAdapter : MyHandlerAdapter {

    override fun support(handler: Any): Boolean {
       return handler is ControllerV4
    }

    override fun handle(req: HttpServletRequest, resp: HttpServletResponse, handler: Any): ModelView {
        val controller = handler as ControllerV4


        val model = paramMapToModel(req)

        val viewName = controller.proc(model)
        val modelView = ModelView(viewName)
        modelView.model.putAll(model)

        return modelView
    }

    private fun paramMapToModel(req: HttpServletRequest): MutableMap<String, Any> {
        val paramMap: MutableMap<String, Any> = mutableMapOf()
        req.parameterNames.asIterator()
            .forEachRemaining { paramName -> paramMap[paramName] = req.getParameter(paramName) }
        return paramMap
    }
}