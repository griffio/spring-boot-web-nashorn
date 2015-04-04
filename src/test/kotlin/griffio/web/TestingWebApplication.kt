package griffio.web

import griffio.Application
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import kotlin.properties.Delegates

RunWith(javaClass<SpringJUnit4ClassRunner>())
SpringApplicationConfiguration(classes = array(javaClass<Application>()))
WebAppConfiguration
public class TestingWebApplication () {

    var mockMvc: MockMvc by Delegates.notNull()

    Before
    public fun setup() {
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    Test fun testHelloWorld() {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("home/hello"))
//                .andExpect(model().attribute("message", "Hello World!"))
    }

    Test
    public fun testGetSomething() {

    }

}