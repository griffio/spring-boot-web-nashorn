package griffio.web

import griffio.Application
import org.hamcrest.core.StringContains
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.properties.Delegates

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(Application::class))
@WebAppConfiguration
public class TestingWebApplication () {

    val indexFixture = "Welcome"
    val aboutFixture = "<html><head><title>The title</title></head><body><p>The body</p></body></html>"
    val loginFixture = "<label>Username</label>"
    val commentFixture = "<p>This is the first comment </p>"

    var mockMvc: MockMvc by Delegates.notNull()

    @Autowired
    var applicationContext : WebApplicationContext? = null

    @Before
    public fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build()
    }

    @Test
    public fun root() {
        mockMvc.perform(get("/about.html"))
                .andExpect(status().isOk)
                .andExpect(content().string(aboutFixture))
    }

    @Test
    public fun index() {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk)
                .andExpect(content().string(StringContains.containsString(indexFixture)))
    }

    @Test
    public fun login() {
        mockMvc.perform(get("/login.html"))
                .andExpect(status().isOk)
                .andExpect(content().string(StringContains.containsString(loginFixture)))
    }

    @Test
    public fun comments() {
        mockMvc.perform(get("/comments.html"))
                .andExpect(status().isOk)
                .andExpect(content().string(StringContains.containsString(commentFixture)))
    }

}