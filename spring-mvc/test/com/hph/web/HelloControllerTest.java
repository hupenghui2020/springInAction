package com.hph.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * 使用mock进行http请求测试
 */
public class HelloControllerTest {

    @Test
    public void testHome() throws Exception {

        HelloController helloController = new HelloController();

        MockMvc mockMvc = standaloneSetup(helloController).build();

        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }
}
