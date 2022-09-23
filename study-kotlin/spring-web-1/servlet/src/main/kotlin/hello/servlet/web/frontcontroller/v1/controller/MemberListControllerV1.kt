package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV1 : ControllerV1 {


    private val memberRepository = MemberRepository.instance

    override fun proc(req: HttpServletRequest, resp: HttpServletResponse) {

        val members = memberRepository.findAll()

        req.setAttribute("members", members)

        val viewPath = "/WEB-INF/views/members.jsp"
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, resp)
    }


}