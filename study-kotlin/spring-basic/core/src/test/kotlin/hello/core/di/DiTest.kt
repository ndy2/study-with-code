package hello.core.di

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

class DiTest {

    private val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    fun constructorDi() {
        val bean = ac.getBean("diTest.ConstructorDi", ConstructorDi::class.java)

        assertThat(bean.hello()).isEqualTo("hello")
    }

    @Test
    fun setterDi() {
        val bean = ac.getBean("diTest.SetterDi", SetterDi::class.java)

        assertThat(bean.hello()).isEqualTo("hello")
    }

    @Test
    fun fieldDi() {
        val bean = ac.getBean("diTest.FieldDi", FieldDi::class.java)

        assertThat(bean.hello()).isEqualTo("hello")
    }

    @Test
    fun methodDi() {
        val bean = ac.getBean("diTest.MethodDi", MethodDi::class.java)

        assertThat(bean.hello()).isEqualTo("hello")
    }


    @Configuration
    @ComponentScan(
        basePackages = ["hello.core.di"]
    )
    class TestConfig {
    }

    @Component
    class ConstructorDi
    @Autowired constructor(
        val beanA: BeanA
    ) {
        fun hello(): String {
            return beanA.hello()
        }
    }

    @Component
    class SetterDi {

        @set:Autowired
        @set:Deprecated("haha")
        lateinit var beanA: BeanA

        fun hello(): String {
            return beanA.hello()
        }
    }

    @Component
    class FieldDi {

        @Autowired
        private lateinit var beanA: BeanA

        fun hello(): String {
            return beanA.hello()
        }
    }

    @Component
    class MethodDi {

        lateinit var beanA: BeanA

        @Autowired
        fun init(beanA: BeanA) {
            this.beanA = beanA;
        }

        fun hello(): String {
            return beanA.hello()
        }
    }

    @Component
    class BeanA {

        fun hello(): String {
            return "hello"
        }
    }
}