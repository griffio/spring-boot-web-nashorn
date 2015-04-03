package griffio.web

import jdk.nashorn.api.scripting.NashornScriptEngine
import org.springframework.web.servlet.view.AbstractTemplateView
import java.io.ByteArrayOutputStream
import javax.script.ScriptEngineManager
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class NashornView : AbstractTemplateView () {

    init {
        val nashornScriptEngine = ScriptEngineManager().getEngineByName("nashorn")
    }

    override fun renderMergedTemplateModel(model: MutableMap<String, Any>?, request: HttpServletRequest?, response: HttpServletResponse?) {
        val output = ByteArrayOutputStream()
        output.write("<html><p>Hello</p></html>".toByteArray("UTF-8"))
        writeToResponse(response, output)
    }
}