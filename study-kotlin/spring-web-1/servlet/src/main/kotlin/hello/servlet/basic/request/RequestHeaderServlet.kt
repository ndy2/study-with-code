package hello.servlet.basic.request

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestHeaderServlet", urlPatterns = ["/request-header"])
class RequestHeaderServlet : HttpServlet() {


    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        checkNotNull(req)

        printStartLine(req)
        printHeaders(req)
        printHeaderUtils(req)
        printEtc(req)
    }

    //start line 정보
    private fun printStartLine(req: HttpServletRequest) {
        println("--- REQUEST-LINE - start ---");

        println("request.getMethod() = " + req.method) //GET
        println("req.getProtocol() = " + req.protocol) // HTTP/1.1
        println("req.getScheme() = " + req.scheme) //http
        println("req.getRequestURL() = " + req.requestURL) // http://localhost:8080/request-header
        println("request.getRequestURI() = " + req.requestURI) //username=hi
        println("request.getQueryString() = " + req.queryString)
        println("request.isSecure() = " + req.isSecure) //https 사용 유무

        println("--- REQUEST-LINE - end ---")
        println()
    }

    private fun printHeaders(req: HttpServletRequest) {
        println("--- Headers - start ---")

        req.headerNames.asIterator()
            .forEachRemaining { headerName -> println("$headerName :${req.getHeader(headerName)}") }

        println("--- Headers - end ---")
        println()
    }

    //Header 편리한 조회
    private fun printHeaderUtils(req: HttpServletRequest) {
        println("--- Header 편의 조회 start ---")

        println("[Host 편의 조회]"); println("request.getServerName() = " + req.serverName)
        println("request.getServerPort() = " + req.serverPort)
        println()

        println("[Accept-Language 편의 조회]")
        req.locales.asIterator()
            .forEachRemaining { locale -> println("locale  = $locale") }
        println()

        println("[cookie 편의 조회]")
        req.cookies?.iterator()?.forEachRemaining { cookie -> println("cookie = $cookie") }
        println()

        println("[Content 편의 조회]")
        println("request.getContentType() = " + req.contentType)
        println("request.getContentLength() = " + req.contentLength)
        println("request.getCharacterEncoding() = " + req.characterEncoding)
        println()

        println("--- Header 편의 조회 end ---")
        println()
    }

    private fun printEtc(req: HttpServletRequest) {
        println("--- 기타 조회 start ---")
        println("[Remote 정보]")
        println("request.getRemoteHost() = " + req.remoteHost)
        println("request.getRemoteAddr() = " + req.remoteAddr)
        println("request.getRemotePort() = " + req.remotePort)

        println()
        println("[Local 정보]")
        println("request.getLocalName() = " + req.localName)
        println("request.getLocalAddr() = " + req.localAddr)
        println("request.getLocalPort() = " + req.localPort)
        println("--- 기타 조회 end ---")
        println()
    }

}