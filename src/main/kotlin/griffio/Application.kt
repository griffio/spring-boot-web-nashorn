package griffio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.ErrorPage
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer

SpringBootApplication
open public class Application {

    Bean
    open fun containerCustomizer() : EmbeddedServletContainerCustomizer {

        return object : EmbeddedServletContainerCustomizer {
            override fun customize(container: ConfigurableEmbeddedServletContainer?) {
                container?.addErrorPages(ErrorPage(HttpStatus.NOT_FOUND, "/404.html"))
            }
        }

    }

}

public fun main(args: Array<String>) {
    SpringApplication.run(javaClass<Application>(), *args)

}


