package griffio.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver

Configuration
open class WebApplication : WebMvcConfigurerAdapter() {

    override fun configureViewResolvers(registry: ViewResolverRegistry?) {
        super.configureViewResolvers(registry)
        var viewResolver : ScriptTemplateViewResolver = ScriptTemplateViewResolver()
        viewResolver.setSuffix(".mst")
        registry?.viewResolver(viewResolver)
        registry?.scriptTemplate()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.addResourceHandler("/webjars/**")?.addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    Bean
    open fun configureScript(): ScriptTemplateConfigurer {
        val configurer: ScriptTemplateConfigurer = ScriptTemplateConfigurer()
        configurer.setEngineName("nashorn")
        configurer.setScripts("/META-INF/resources/webjars/mustachejs/0.8.2/mustache.js", "/templates/render.js")
        configurer.setRenderObject("Mustache")
        configurer.setRenderFunction("render")
        return configurer
    }

}