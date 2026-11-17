package com.example.controllertestingdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class ControllerTestingDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddition() throws Exception {
        mockMvc.perform(get("/api/add")
                .param("a", "10")
                .param("b", "20"))
                .andExpect(status().isOk())
                .andExpect(content().string("30"));
    }

    @Test
    void testSubtraction() throws Exception {
        mockMvc.perform(get("/api/subtract")
                .param("a", "20")
                .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void testMultiplication() throws Exception {
        mockMvc.perform(get("/api/multiply")
                .param("a", "5")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("20"));
    }

    @Test
    void testDivision() throws Exception {
        mockMvc.perform(get("/api/divide")
                .param("a", "20")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("4"));
    }

    @Test
    void testAddUser() throws Exception {
        mockMvc.perform(post("/api/users")
                .param("id", "1")
                .param("name", "Raja"))
                .andExpect(status().isOk())
                .andExpect(content().string("User Added Successfully"));
    }

    @Test
    void testGetUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User Deleted Successfully"));
    }
}