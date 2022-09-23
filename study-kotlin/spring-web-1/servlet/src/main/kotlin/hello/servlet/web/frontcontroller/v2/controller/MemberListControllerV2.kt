package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV2 : ControllerV2 {


    private val memberRepository = MemberRepository.instance

    override fun proc(req: HttpServletRequest, resp: HttpServletResponse) : MyView {

        val members = memberRepository.findAll()
        req.setAttribute("members", members)

        return MyView("/WEB-INF/views/members.jsp")
    }


}