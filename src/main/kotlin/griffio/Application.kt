package griffio

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.ErrorPage
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus

@SpringBootApplication
open class Application {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Bean
    open fun containerCustomizer(): EmbeddedServletContainerCustomizer {
        return EmbeddedServletContainerCustomizer { container ->
            container?.addErrorPages(ErrorPage(HttpStatus.NOT_FOUND, "/404.html"))
            container?.addErrorPages(ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html"))
        }
    }
}
