package hello.core.scan

import hello.core.AutoAppConfig
import hello.core.member.service.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {


    @Test
    fun `기본 스캔`() {
        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

        val memberService = ac.getBean("memberServiceImpl", MemberService::class.java)

        assertThat(memberService).isNotNull()
    }
}