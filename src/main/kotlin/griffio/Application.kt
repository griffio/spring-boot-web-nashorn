package griffio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer

ComponentScan
EnableAutoConfiguration
EnableWebMvc
public class Application : WebMvcConfigurerAdapter() {

    override fun configureViewResolvers(registry: ViewResolverRegistry?) {
        super.configureViewResolvers(registry)
        registry?.scriptTemplate()
    }

    Bean
    fun configureScript() : ScriptTemplateConfigurer {
        val configurer : ScriptTemplateConfigurer = ScriptTemplateConfigurer()
        configurer.setEngineName("nashorn")
        configurer.setScripts("mustache.js")
        configurer.setRenderObject("Mustache")
        configurer.setRenderFunction("render")
        return configurer
    }

}

public fun main(args: Array<String>) {
    SpringApplication.run(javaClass<Application>(), *args)
}


