package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PeopleGeneratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGenerateNumber() throws Exception {
        mockMvc.perform(get("/generate_number"))
                .andExpect(status().isOk());
    }

    @Test
    void testGenerateName() throws Exception {
        mockMvc.perform(get("/generate_name"))
                .andExpect(status().isOk());
    }

    @Test
    void testGeneratePerson() throws Exception {
        mockMvc.perform(get("/generate_person"))
                .andExpect(status().isOk());
    }

    @Test
    void testAverageAge() throws Exception {
        mockMvc.perform(get("/avgerage_age"))
                .andExpect(status().isOk());
    }
}