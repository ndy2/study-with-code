package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4 : ControllerV4 {

    private val memberRepository = MemberRepository.instance

    override fun proc(model: MutableMap<String, Any>): String {
        // 파라미터 바인딩
        val username = model["username"] as String
        val age = Integer.parseInt(model["age"] as String)

        // 회원 생성, 저장
        val member = Member(username, age)
        memberRepository.save(member)

        // 모델에 담기
        model["member"] = member
        return "save-result"
    }
}