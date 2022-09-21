package hello.core.member.service

import hello.core.member.domain.Member
import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository

class MemberServiceImpl : MemberService {

    private val memberRepository: MemberRepository = HashMapMemberRepository()

    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(id: Long): Member {
        return memberRepository.findById(id)
    }
}