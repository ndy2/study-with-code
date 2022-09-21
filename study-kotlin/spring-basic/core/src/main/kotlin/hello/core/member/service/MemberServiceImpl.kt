package hello.core.member.service

import hello.core.member.domain.Member
import hello.core.member.domain.MemberRepository

class MemberServiceImpl(
    private val memberRepository: MemberRepository
) : MemberService {


    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(id: Long): Member {
        return memberRepository.findById(id)
    }
}