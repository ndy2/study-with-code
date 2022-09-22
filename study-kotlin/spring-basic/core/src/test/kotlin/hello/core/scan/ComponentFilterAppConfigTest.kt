package hello.core.scan

import hello.core.AutoAppConfig
import hello.core.scan.filter.BeanExclude
import hello.core.scan.filter.BeanInclude
import hello.core.scan.filter.MyExcludeComponent
import hello.core.scan.filter.MyIncludeComponent
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

class ComponentFilterAppConfigTest {

    @Test
    fun filterScan() {
        val ac = AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)

        assertThat(ac.getBean(BeanInclude::class.java)).isNotNull
        assertThatExceptionOfType(NoSuchBeanDefinitionException::class.java)
            .isThrownBy { ac.getBean(BeanExclude::class.java) }
    }

    @Configuration
    @ComponentScan(
        basePackages = ["hello.core.scan.filter"],
        includeFilters = [ComponentScan.Filter(MyIncludeComponent::class)],
        excludeFilters = [ComponentScan.Filter(MyExcludeComponent::class)]
    )
    class ComponentFilterAppConfig
}