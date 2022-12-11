package fr.proj.ufar.taxiserviceserver.config

import fr.proj.ufar.taxiserviceserver.controller.interceptor.RequestInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(private val requestInterceptor: RequestInterceptor) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(requestInterceptor)
            .addPathPatterns("/api/**")
            .excludePathPatterns("/api/admin/login")
    }
}
