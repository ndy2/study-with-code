package hello.servlet.web.frontcontroller.v5

import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV3
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV3
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV3
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4
import hello.servlet.web.frontcontroller.v5.adpater.ControllerV3HandlerAdapter
import hello.servlet.web.frontcontroller.v5.adpater.ControllerV4HandlerAdapter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "frontControllerServletV5", urlPatterns = ["/front-controller/v5/*"])
class FrontControllerServlet : HttpServlet() {

    private val handlerAdapters: List<MyHandlerAdapter> = listOf(
        ControllerV3HandlerAdapter(),
        ControllerV4HandlerAdapter(),
    )

    private val handlerMappingMap: Map<String, Any> = mapOf(
        "/front-controller/v5/v3/members/new-form" to MemberFormControllerV3(),
        "/front-controller/v5/v3/members/save" to MemberSaveControllerV3(),
        "/front-controller/v5/v3/members" to MemberListControllerV3(),

        "/front-controller/v5/v4/members/new-form" to MemberFormControllerV4(),
        "/front-controller/v5/v4/members/save" to MemberSaveControllerV4(),
        "/front-controller/v5/v4/members" to MemberListControllerV4(),
    )

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {

        handlerMappingMap[req.requestURI].let { handler ->
            if (handler != null) {
                for (ha in handlerAdapters) {
                    if(ha.support(handler)){
                        val mv = ha.handle(req, resp, handler)
                        val view = viewResolver(mv.viewName)
                        view.render(mv.model, req, resp)
                    }
                }
            } else resp.status = HttpServletResponse.SC_NOT_FOUND
        }

    }

    private fun viewResolver(viewName: String) : MyView {
        return MyView("/WEB-INF/views/" + viewName + ".jsp")
    }
}