package hello.servlet.basic.response

import java.io.IOException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ResponseHeaderServlet : HttpServlet() {

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        checkNotNull(req)
        checkNotNull(resp)

        //status line
        resp.status = HttpServletResponse.SC_OK
        resp.setHeader("Content-Type", "text/plain;charset=utf-8")
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        resp.setHeader("Pragma", "no-cache")
        resp.setHeader("my-header", "hello")

        //[Header 편의 메서드]
        content(resp);
        cookie(resp);
        redirect(resp);

        //[message body]
        resp.writer.println("ok")
    }

    private fun content(response: HttpServletResponse) {
        response.contentType = "text/plain";
        response.characterEncoding = "utf-8";
    }

    private fun cookie(response: HttpServletResponse) {
        val cookie: Cookie = Cookie("myCookie", "good")
        cookie.maxAge = 600 //600초
        response.addCookie(cookie)
    }

    private fun redirect(response: HttpServletResponse) {
        response.status = HttpServletResponse.SC_FOUND; //302
        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html")
    }

}