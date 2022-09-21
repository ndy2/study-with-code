package hello.core

import hello.core.discount.DiscountPolicy
import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository
import hello.core.member.service.MemberService
import hello.core.member.service.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextBasicFindTest {

    private val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `빈 이름으로 조회`() {
        val memberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `빈 이름으로 조회 실패`() {
        assertThatExceptionOfType(NoSuchBeanDefinitionException::class.java)
            .isThrownBy { ac.getBean("haha") }
    }

    @Test
    fun `이름 없이 타입으로만 조회`() {
        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    fun `구체 타입으로 조회`() {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

}