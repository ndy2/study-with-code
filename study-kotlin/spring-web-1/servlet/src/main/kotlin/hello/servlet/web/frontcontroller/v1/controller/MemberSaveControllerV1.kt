package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV1 : ControllerV1 {

    private val memberRepository = MemberRepository.instance

    override fun proc(req: HttpServletRequest, resp: HttpServletResponse) {
        val username = req.getParameter("username")
        val age = Integer.parseInt(req.getParameter("age"))

        val member = Member(username, age)
        memberRepository.save(member)

        //Model에 데이터를 보관한다
        req.setAttribute("member", member)

        val viewPath = "/WEB-INF/views/save-result.jsp"
        val dispatcher = req.getRequestDispatcher(viewPath)
        dispatcher.forward(req, resp)
    }

}