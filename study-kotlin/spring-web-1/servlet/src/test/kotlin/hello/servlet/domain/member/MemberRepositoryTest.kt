package hello.servlet.domain.member

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemberRepositoryTest {

    private var memberRepository = MemberRepository.instance

    @AfterEach
    fun tearDown() {
        memberRepository.clear()
    }

    @Test
    fun save() {
        //given
        val expected = Member("hello", 20)

        //when
        val actual = memberRepository.save(expected)

        then(actual).isEqualTo(expected)
    }

    @Test
    fun findAll() {
        //given
        val expected = listOf(
            Member("hello1", 20),
            Member("hello2", 20),
        )
        expected.forEach(memberRepository::save)

        //when
        val actual = memberRepository.findAll()

        then(actual).hasSameSizeAs(expected)
        then(actual).hasSameElementsAs(expected)
    }
}