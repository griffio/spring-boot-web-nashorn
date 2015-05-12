package griffio.web

import com.google.common.collect.Lists
import griffio.model.Comment
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

Controller
public class Routes {

    RequestMapping(value = array("/about.html"))
    fun index(model: Model) {
        model.addAttribute("title", "The title")
        model.addAttribute("body", "The body")
    }

    RequestMapping(value = array("/login.html"))
    fun long(model: Model) {
        model.addAttribute("title", "Login Page")
    }

    RequestMapping(value = array("/comments.html"))
    fun comments(model: Model) {
        val items = listOf(Comment(1, "griffio", "This is the first comment"), Comment(2, "griffio", "This is the second comment"))
        model.addAttribute("comments", items)
    }

}
