package com.gurung.springsecuritydemo1.controller;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HelloControllerTest extends BaseIT{
    @Test
    void getHello() throws Exception {
        mockMvc.perform(get("/hello/get-hello"))
                .andExpect(status().isOk());
    }

    @Test
    void test_deleteHeroById() throws Exception {
        mockMvc.perform(delete("/hello/get-hello")
                        .header("api-key","scott")
                        .header("api-secret","tiger")
                )
                .andExpect(status().isOk());
    }
}