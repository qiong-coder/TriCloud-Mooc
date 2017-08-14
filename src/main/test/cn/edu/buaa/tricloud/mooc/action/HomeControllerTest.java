package cn.edu.buaa.tricloud.mooc.action;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by qixiang on 8/14/17.
 */
public class HomeControllerTest {


    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

    @Test
    public void shouldShowRegistration() throws Exception {
        HomeController homeController = new HomeController();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

        mockMvc.perform(get("/register"))
                .andExpect(view().name("registerForm"));
    }
}
