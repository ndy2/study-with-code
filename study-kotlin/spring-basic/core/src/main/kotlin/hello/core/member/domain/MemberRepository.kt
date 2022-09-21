package hello.core.member.domain

interface MemberRepository {

    fun save(member: Member)
    fun findById(id: Long): Member
}