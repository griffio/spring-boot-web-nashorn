package griffio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.ErrorPage
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus

@SpringBootApplication
open public class Application {

    @Bean
    open fun containerCustomizer() : EmbeddedServletContainerCustomizer {

        return object : EmbeddedServletContainerCustomizer {
            override fun customize(container: ConfigurableEmbeddedServletContainer?) {
                container?.addErrorPages(ErrorPage(HttpStatus.NOT_FOUND, "/404.html"))
            }
        }

    }

}

public fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)

}


