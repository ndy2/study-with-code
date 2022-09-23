package hello.servlet.web.frontcontroller.v2

import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV2", urlPatterns = ["/front-controller/v2/*"])
class FrontControllerServletV2 : HttpServlet() {

    private val controllerMap: Map<String, ControllerV2> = mapOf(
        "/front-controller/v2/members/new-form" to MemberFormControllerV2(),
        "/front-controller/v2/members/save" to MemberSaveControllerV2(),
        "/front-controller/v2/members" to MemberListControllerV2(),
    )

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        controllerMap[req.requestURI]?.proc(req, resp)

        controllerMap[req.requestURI].let { controller ->
            if (controller != null) {
                val myView = controller.proc(req, resp)
                myView.render(req, resp)
            }
            else resp.status = HttpServletResponse.SC_NOT_FOUND
        }
    }
}