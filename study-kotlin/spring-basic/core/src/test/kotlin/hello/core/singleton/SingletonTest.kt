package hello.core.singleton

import hello.core.AppConfig
import hello.core.member.service.MemberServiceImpl
import hello.core.order.service.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {

    @Test
    fun `순수 appConfig`() {
        val appConfig = AppConfig()

        val memberService1 = appConfig.memberService()
        val memberService2 = appConfig.memberService()

        assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    fun `스프링 ac`() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberRepository1 = ac.getBean(MemberServiceImpl::class.java).memberRepository
        val memberRepository2 = ac.getBean(OrderServiceImpl::class.java).memberRepository

        println("ac = ${ac.getBean(AppConfig::class.java)}")
        println("memberRepository1 = ${memberRepository1}")
        println("memberRepository2 = ${memberRepository2}")

        assertThat(memberRepository1).isSameAs(memberRepository2)
//        assertThat(memberRepository1).isNotSameAs(memberRepository2)
    }
}