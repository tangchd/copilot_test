package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Spring Boot Web Application!"));
    }

    @Test
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Application is running!"));
    }

    @Test
    void testMcpServicesEndpoint() throws Exception {
        mockMvc.perform(get("/mcp/services"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("filesystem"))
                .andExpect(jsonPath("$[0].description").value("文件系统访问服务"))
                .andExpect(jsonPath("$[0].version").value("1.0.0"))
                .andExpect(jsonPath("$[0].capabilities[0]").value("read_file"))
                .andExpect(jsonPath("$[1].name").value("database"))
                .andExpect(jsonPath("$[2].name").value("web-search"))
                .andExpect(jsonPath("$[3].name").value("code-analysis"))
                .andExpect(jsonPath("$[4].name").value("memory"));
    }
}