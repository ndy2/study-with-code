package hello.core.scan.filter

import java.lang.annotation.ElementType

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyIncludeComponent()
