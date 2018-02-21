package griffio.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver
import java.util.Properties

@Configuration
open class WebApplication : WebMvcConfigurerAdapter() {

    override fun configureViewResolvers(registry: ViewResolverRegistry?) {
        super.configureViewResolvers(registry)
        val viewResolver = ScriptTemplateViewResolver()
        viewResolver.setPrefix("/templates/")
        viewResolver.setSuffix(".jsx")
        registry?.viewResolver(viewResolver)
        registry?.scriptTemplate()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.addResourceHandler("/webjars/**")?.addResourceLocations("classpath:/META-INF/resources/webjars/")
    }

    @Bean
    open fun configureScript(): ScriptTemplateConfigurer {
        val configurer = ScriptTemplateConfigurer()
        configurer.engineName = "nashorn"
        configurer.setScripts(
                "/META-INF/resources/webjars/react/16.1.0/react.production.min.js",
                "/META-INF/resources/webjars/react/16.1.0/react-dom-server.browser.production.min.js",
                "/babel.min.js",
                "/create-react-class.min.js",
                "/react-templating.js")
        configurer.isSharedEngine = false
        configurer.renderFunction = "renderJsx"
        return configurer
    }

    @Bean
    open fun createSimpleMappingExceptionResolver(): SimpleMappingExceptionResolver {
        val er = SimpleMappingExceptionResolver()
        val mappings = Properties()
        er.setExceptionMappings(mappings)
        er.setExceptionAttribute("ex")
        er.setDefaultErrorView("error")
        return er
    }
}
