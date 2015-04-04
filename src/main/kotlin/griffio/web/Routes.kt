package griffio.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

Controller
public class Routes {

    RequestMapping(value = array("/"))
    fun index(model: Model) : String {
        model.addAttribute("title", "The title")
        model.addAttribute("body", "The body")
        return "/templates/index"
    }

}