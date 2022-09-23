package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v2.ControllerV2
import hello.servlet.web.frontcontroller.v3.ControllerV3
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV3 : ControllerV3 {

    private val memberRepository = MemberRepository.instance

    override fun proc(paramMap: Map<String, String>): ModelView {
        val username = paramMap["username"]!!
        val age = paramMap["age"]!!.toInt()

        val member = Member(username, age)
        memberRepository.save(member)

        //Model에 데이터를 보관한다

        val modelView = ModelView("save-result")
        modelView.model["member"] = member
        return modelView
    }

}