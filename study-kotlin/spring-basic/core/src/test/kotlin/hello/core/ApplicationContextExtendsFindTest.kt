package hello.core

import hello.core.discount.DiscountPolicy
import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class ApplicationContextExtendsFindTest {

    private val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    fun `부모 타입으로 조회 시 자식이 둘 이상 있으면, 중복 오류가 발생한다`() {

        assertThatExceptionOfType(NoUniqueBeanDefinitionException::class.java)
            .isThrownBy { ac.getBean(DiscountPolicy::class.java) }
    }

    @Test
    fun `자식이 둘  이상 있으면, 빈 이름을 지정하면 된다`() {
        val bean = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    fun `자식이 둘  이상 있으면, 구체 타입을 지정하면 된다`() {
        val bean = ac.getBean(RateDiscountPolicy::class.java)
        assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    fun `부모 타입으로 모두 조회하기`() {
        val beansOfType = ac.getBeansOfType(DiscountPolicy::class.java)

        for (entry in beansOfType) {
            println("key : ${entry.key}, value : ${entry.value}")
        }
        assertThat(beansOfType).hasSize(2)
    }

    @Test
    fun `부모 타입으로 모두 조회하기 - Any`() {
        val beansOfType = ac.getBeansOfType(Any::class.java)

        for (entry in beansOfType) {
            println("key : ${entry.key}, value : ${entry.value}")
        }
    }

    class TestConfig {

        @Bean
        fun rateDiscountPolicy(): DiscountPolicy {
            return RateDiscountPolicy()
        }

        @Bean
        fun fixDiscountPolicy(): DiscountPolicy {
            return FixDiscountPolicy()
        }
    }
}