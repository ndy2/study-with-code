package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV2 : ControllerV2 {

    private val memberRepository = MemberRepository.instance

    override fun proc(req: HttpServletRequest, resp: HttpServletResponse): MyView {
        val username = req.getParameter("username")
        val age = Integer.parseInt(req.getParameter("age"))

        val member = Member(username, age)
        memberRepository.save(member)

        //Model에 데이터를 보관한다
        req.setAttribute("member", member)

        return MyView("/WEB-INF/views/save-result.jsp")
    }

}