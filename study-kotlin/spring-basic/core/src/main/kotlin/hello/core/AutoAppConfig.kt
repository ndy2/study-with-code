package hello.core

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(
    basePackages = ["hello.core"],
    basePackageClasses = [AutoAppConfig::class],
    excludeFilters = [ComponentScan.Filter(Configuration::class)]
)
class AutoAppConfig {
}