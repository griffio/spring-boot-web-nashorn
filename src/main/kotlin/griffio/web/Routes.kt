package griffio.web

import griffio.HealthCheck
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

RestController
public class Routes {

    val counter = AtomicLong()

    RequestMapping(value = array("/health"))
    public fun greeting(RequestParam(value = "message", defaultValue = "OK") name: String): HealthCheck {
        return HealthCheck(counter.incrementAndGet(), "$name")
    }
}