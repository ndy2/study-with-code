package hello.core.ac

import hello.core.AppConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    private val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    fun `모든 빈 출력하기`() {
        val beanDefinitionNames = ac.beanDefinitionNames
        for (beanDefinitionName in beanDefinitionNames) {
            val bean = ac.getBean(beanDefinitionName)
            println("beanDefinitionName = ${beanDefinitionName}, bean = ${bean}")
        }
    }

    @Test
    fun `애플리케이션 빈 출력하기`() {
        val beanDefinitionNames = ac.beanDefinitionNames

        for (beanDefinitionName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanDefinitionName)
            val bean = ac.getBean(beanDefinitionName)

            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                println("beanDefinitionName = ${beanDefinitionName}, bean = ${bean}")
            }
        }
    }
}