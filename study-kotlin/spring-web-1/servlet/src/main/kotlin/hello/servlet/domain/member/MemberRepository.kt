package hello.servlet.domain.member

import java.lang.RuntimeException

class MemberRepository private constructor() {

    companion object {
        private val store = HashMap<Long?, Member>()
        private var sequence: Long = 0L

        val instance = MemberRepository()
    }

    fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    fun findById(id: Long): Member {

        return store[id] ?: throw RuntimeException()
    }

    fun findAll(): List<Member> {

        return store.values.toList()
    }

    fun clear(){
        store.clear()
    }
}