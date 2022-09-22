package hello.servlet.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import hello.servlet.basic.HelloData
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets.UTF_8
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet : HttpServlet(){

    private val objectMapper = ObjectMapper()

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
        checkNotNull(req)
        checkNotNull(resp)

        val inputStream = req.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, UTF_8)

        println("messageBody = ${messageBody}")

        val helloData = objectMapper.readValue<HelloData>(messageBody)
        println("helloData = ${helloData}")
    }
}