package griffio.web

import griffio.model.Comment
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
public class Routes {

    @RequestMapping(value = "/about.html")
    fun index(model: Model) {
        model.addAttribute("title", "The title")
        model.addAttribute("body", "The body")
    }

    @RequestMapping(value = "/login.html")
    fun long(model: Model) {
        model.addAttribute("title", "Login Page")
    }

    @RequestMapping(value = "/comments.html")
    fun comments(model: Model) {
        val items = listOf(Comment(1, "griffio", "This is the first comment"), Comment(2, "griffio", "This is the second comment"))
        model.addAttribute("comments", items)
    }

}
