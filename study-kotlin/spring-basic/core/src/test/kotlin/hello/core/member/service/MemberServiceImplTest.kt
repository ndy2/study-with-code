package hello.core.member.service

import hello.core.AppConfig
import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class MemberServiceImplTest{

    private val memberService = AppConfig().memberService()

    @Test
    fun `조인하고 조회 성공`() {
        //given
        val expected = Member(1L, "memberA", Grade.VIP)
        memberService.join(expected)

        //when
        val actual = memberService.findMember(1L)

        then(actual).isEqualTo(expected)
    }
}