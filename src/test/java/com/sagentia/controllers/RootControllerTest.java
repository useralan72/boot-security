package com.sagentia.controllers;

import com.sagentia.NeptunespringbootdemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by AE2 on 24/06/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = RootController.class, secure = true)
public class RootControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() {
    }

    //@Test
    //@WithMockUser(username = "user", password = "test", roles = "GOLD")
    //public void givenRoleGoldShouldGiveGoldUrl() throws Exception {
    //    mockMvc.perform(get("/")
     //           .with(user("admin").roles("GOLD")))
     //           .andExpect(status().isOk())
    //            .andDo(print());
    //}

    @Test
    @WithMockUser(username = "user", password = "test", roles = "GOLD")
    public void givenRoleGoldShouldGiveUrl() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
