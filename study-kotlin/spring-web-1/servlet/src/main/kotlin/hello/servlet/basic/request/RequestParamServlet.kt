package hello.servlet.basic.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestParamServlet", urlPatterns = ["/request-param"])
class RequestParamServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        checkNotNull(req)
        checkNotNull(resp)

        println("[전체 파라미터 조회] - start")

        req.parameterNames.asIterator()
            .forEachRemaining { paramName -> println("$paramName=${req.getParameter(paramName)}") }
        println("[전체 파라미터 조회] - end")
        println()

        println("[단일 파라미터 조회]")
        val username: String = req.getParameter("username")
        println ("request.getParameter(username) = $username")

        val age: String = req.getParameter("age")
        println("request.getParameter(age) = $age")
        println()

        println("[이름이 같은 복수 파라미터 조회]")
        println ("request.getParameterValues(username)")

        val usernames: Array<String> = req.getParameterValues("username")
        for (name in usernames) {
            println("username=$name")
        }

        resp.writer.write("ok")
    }
}