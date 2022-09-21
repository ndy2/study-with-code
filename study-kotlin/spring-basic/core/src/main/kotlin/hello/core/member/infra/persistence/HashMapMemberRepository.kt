package hello.core.member.infra.persistence

import hello.core.member.domain.Member
import hello.core.member.domain.MemberRepository

class HashMapMemberRepository : MemberRepository {

    companion object {
        val store = HashMap<Long?, Member>()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }
}