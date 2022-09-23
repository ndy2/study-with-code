package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberListControllerV4 : ControllerV4 {


    private val memberRepository = MemberRepository.instance

    override fun proc(model: MutableMap<String, Any>): String {
        val members = memberRepository.findAll()
        model["members"] = members

        return "members"
    }

}