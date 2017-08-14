package cn.edu.buaa.tricloud.mooc.action;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by qixiang on 8/14/17.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
    }
}
