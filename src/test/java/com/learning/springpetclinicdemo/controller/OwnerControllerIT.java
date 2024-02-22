package com.learning.springpetclinicdemo.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OwnerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllOwners() throws Exception {
        String jsonResponse = mockMvc.perform(get("/owners")
                                                      .contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                     .andExpect(status().isOk())
                                     .andReturn().getResponse().getContentAsString();

        String john = JsonPath.parse(jsonResponse).read("$[0].firstName");
        String jane = JsonPath.parse(jsonResponse).read("$[1].firstName");
        assertThat(john).isEqualTo("John");
        assertThat(jane).isEqualTo("Jane");
    }

}
