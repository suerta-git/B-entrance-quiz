package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void should_get_6_groups_given_group_total_number_6() throws Exception {
        mockMvc.perform(get("/group?total=6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6))
                .andExpect(jsonPath("$[0].students.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("1 组"))
                .andExpect(jsonPath("$[3].students.length()").value(2))
                .andExpect(jsonPath("$[3].name").value("4 组"));
    }

    @Test
    public void should_get_10_groups_given_group_total_number_10() throws Exception {
        mockMvc.perform(get("/group?total=10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10))
                .andExpect(jsonPath("$[0].students.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("1 组"))
                .andExpect(jsonPath("$[5].students.length()").value(1))
                .andExpect(jsonPath("$[5].name").value("6 组"));
    }

    @Test
    public void should_get_6_groups_not_given_group_total_number() throws Exception {
        mockMvc.perform(get("/group"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(6))
                .andExpect(jsonPath("$[0].students.length()").value(3))
                .andExpect(jsonPath("$[0].name").value("1 组"))
                .andExpect(jsonPath("$[3].students.length()").value(2))
                .andExpect(jsonPath("$[3].name").value("4 组"));
    }

    @Test
    public void should_throw_exception_when_total_number_is_invalid() throws Exception {
        mockMvc.perform(get("/group?total=0"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Total group number should >= 1"));
        mockMvc.perform(get("/group?total=1.1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Total group number should be an integer"));
    }
}