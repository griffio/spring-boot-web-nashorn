package griffio.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
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
        var viewResolver: ScriptTemplateViewResolver = ScriptTemplateViewResolver()
        viewResolver.setPrefix("/templates/")
        viewResolver.setSuffix(".jsx")
        registry?.viewResolver(viewResolver)
        registry?.scriptTemplate()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.addResourceHandler("/webjars/**")?.addResourceLocations("classpath:/META-INF/resources/webjars/")
    }

    override fun addViewControllers(registry: ViewControllerRegistry?) {
        super.addViewControllers(registry)
    }

    @Bean
    open fun configureScript(): ScriptTemplateConfigurer {
        val configurer: ScriptTemplateConfigurer = ScriptTemplateConfigurer()
        configurer.engineName = "nashorn"
        configurer.setScripts(
                "/META-INF/resources/webjars/react/15.0.0/react.min.js",
                "/META-INF/resources/webjars/react/15.0.0/react-dom-server.min.js",
                "/babel.min.js",
                "/react-templating.js")
        configurer.renderFunction = "renderJsx"
        return configurer
    }

    @Bean
    open fun createSimpleMappingExceptionResolver(): SimpleMappingExceptionResolver {
        var er: SimpleMappingExceptionResolver = SimpleMappingExceptionResolver()
        var mappings: Properties = Properties()
        er.setExceptionMappings(mappings)
        er.setExceptionAttribute("ex")
        er.setDefaultErrorView("error")
        return er
    }

}