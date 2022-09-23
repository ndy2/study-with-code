package hello.servlet.web.frontcontroller.v3

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV3
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV3
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV3
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV3", urlPatterns = ["/front-controller/v3/*"])
class FrontControllerServletV3 : HttpServlet() {

    private val controllerMap: Map<String, ControllerV3> = mapOf(
        "/front-controller/v3/members/new-form" to MemberFormControllerV3(),
        "/front-controller/v3/members/save" to MemberSaveControllerV3(),
        "/front-controller/v3/members" to MemberListControllerV3(),
    )

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        controllerMap[req.requestURI].let { controller ->
            if (controller != null) {
                val paramMap: MutableMap<String, String> = createParamMap(req)
                val mv = controller.proc(paramMap)
                val view = viewResolver(mv.viewName)
                view.render(mv.model, req, resp)
            } else resp.status = HttpServletResponse.SC_NOT_FOUND
        }
    }

    private fun viewResolver(viewName: String) : MyView {
        return MyView("/WEB-INF/views/" + viewName + ".jsp")
    }

    private fun createParamMap(req: HttpServletRequest): MutableMap<String, String> {
        val paramMap: MutableMap<String, String> = mutableMapOf()
        req.parameterNames.asIterator()
            .forEachRemaining { paramName -> paramMap[paramName] = req.getParameter(paramName) }
        return paramMap
    }
}