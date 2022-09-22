package hello.core.member.service

import hello.core.member.domain.Member
import hello.core.member.domain.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    val memberRepository: MemberRepository
) : MemberService {

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(id: Long): Member {
        return memberRepository.findById(id)
    }
}