package hello.servlet.web.frontcontroller.v1

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1
import javax.annotation.PostConstruct
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV1", urlPatterns = ["/front-controller/v1/*"])
class FrontControllerServletV1 : HttpServlet() {

    private val controllerMap: Map<String, ControllerV1> = mapOf(
        "/front-controller/v1/members/new-form" to MemberFormControllerV1(),
        "/front-controller/v1/members/save" to MemberSaveControllerV1(),
        "/front-controller/v1/members" to MemberListControllerV1(),
    )

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        controllerMap[req.requestURI]?.proc(req, resp)

        controllerMap[req.requestURI].let { controller ->
            if (controller != null) controller.proc(req, resp)
            else resp.status = HttpServletResponse.SC_NOT_FOUND
        }
    }
}