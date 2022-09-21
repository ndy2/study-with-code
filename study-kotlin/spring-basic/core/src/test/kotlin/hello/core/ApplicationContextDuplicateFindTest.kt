package hello.core

import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository
import hello.core.member.service.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextDuplicateFindTest {

    private val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Test
    fun `타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다`() {
        Assertions.assertThatExceptionOfType(NoUniqueBeanDefinitionException::class.java)
            .isThrownBy { ac.getBean(MemberRepository::class.java) }
    }

    @Test
    internal fun `이름을 지정하면 된다`() {
        val bean = ac.getBean("memberRepository1", MemberRepository::class.java)

        assertThat(bean).isInstanceOf(HashMapMemberRepository::class.java)
    }

    @Test
    fun `대상 타입 전부 조회`() {
        val beansOfType = ac.getBeansOfType(MemberRepository::class.java)

        for (entry in beansOfType) {
            println("key : ${entry.key}, value : ${entry.value}")
        }
        assertThat(beansOfType).hasSize(2)
    }

    @Configuration
    class SameBeanConfig {

        @Bean
        fun memberRepository1(): MemberRepository {
            return HashMapMemberRepository()
        }

        @Bean
        fun memberRepository2(): MemberRepository {
            return HashMapMemberRepository()
        }
    }
}