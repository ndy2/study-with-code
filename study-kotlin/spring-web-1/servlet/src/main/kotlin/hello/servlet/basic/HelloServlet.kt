package hello.servlet.basic

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/hello"])
class HelloServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("HelloServlet.service")

        val username = req?.getParameter("username")
        println("username = $username")

        resp?.contentType = "text/plain"
        resp?.characterEncoding = "utf-8"
        resp?.writer?.write("hello $username")
    }
}