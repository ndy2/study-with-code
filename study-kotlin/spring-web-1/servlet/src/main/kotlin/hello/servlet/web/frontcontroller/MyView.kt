package hello.servlet.web.frontcontroller

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyView(
    private val viewPath: String
) {
    fun render(req: HttpServletRequest, resp: HttpServletResponse) {
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, resp)
    }

    fun render(paramMap: MutableMap<String, Any>, req: HttpServletRequest, resp: HttpServletResponse) {
        paramMap.forEach(req::setAttribute)
        render(req, resp)
    }
}