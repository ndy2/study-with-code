package hello.core.member.service

import hello.core.member.domain.Member

interface MemberService {

    fun join(member: Member)
    fun findMember(id : Long) : Member
}