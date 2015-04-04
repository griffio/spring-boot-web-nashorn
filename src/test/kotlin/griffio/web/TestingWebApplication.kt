package griffio.web

import griffio.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.web.context.WebApplicationContext
import kotlin.properties.Delegates

RunWith(javaClass<SpringJUnit4ClassRunner>())
SpringApplicationConfiguration(classes = array(javaClass<Application>()))
WebAppConfiguration
public class TestingWebApplication () {

    var mockMvc: MockMvc by Delegates.notNull()

    Autowired
    var applicationContext : WebApplicationContext? = null

    Before
    public fun setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    Test
    public fun index() {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("<html><head><title>The title</title></head><body><p>The body</p></body></html>"))
    }

}