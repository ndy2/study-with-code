package hello.servlet.web.frontcontroller.v4

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV4", urlPatterns = ["/front-controller/v4/*"])
class FrontControllerServlet : HttpServlet() {

    private val controllerMap: Map<String, ControllerV4> = mapOf(
        "/front-controller/v4/members/new-form" to MemberFormControllerV4(),
        "/front-controller/v4/members/save" to MemberSaveControllerV4(),
        "/front-controller/v4/members" to MemberListControllerV4(),
    )

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        controllerMap[req.requestURI].let { controller ->
            if (controller != null) {
                val model: MutableMap<String, Any> = paramMapToModel(req)
                val viewName = controller.proc(model)
                val view = viewResolver(viewName)

                view.render(model, req, resp)
            } else resp.status = HttpServletResponse.SC_NOT_FOUND
        }
    }

    private fun viewResolver(viewName: String) : MyView {
        return MyView("/WEB-INF/views/" + viewName + ".jsp")
    }

    private fun paramMapToModel(req: HttpServletRequest): MutableMap<String, Any> {
        val paramMap: MutableMap<String, Any> = mutableMapOf()
        req.parameterNames.asIterator()
            .forEachRemaining { paramName -> paramMap[paramName] = req.getParameter(paramName) }
        return paramMap
    }
}