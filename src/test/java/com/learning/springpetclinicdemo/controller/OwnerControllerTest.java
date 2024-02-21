package com.learning.springpetclinicdemo.controller;

import com.jayway.jsonpath.JsonPath;
import com.learning.springpetclinicdemo.entity.Owner;
import com.learning.springpetclinicdemo.service.OwnerService;
import com.learning.springpetclinicdemo.testsupport.factories.OwnerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(OwnerController.class)
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @Test
    public void testGetAllOwners() throws Exception {
        // Mocking the service response
        List<Owner> owners = Arrays.asList(
                OwnerFactory.createJohnDoe(), OwnerFactory.createJaneSmith());
        Mockito.when(ownerService.getAllOwners()).thenReturn(owners);

        // Performing the GET request and asserting the response
        String jsonResponse=mockMvc.perform(get("/owners")
                                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        String firstName = JsonPath.parse(jsonResponse).read("$[0].firstName");
        assertThat(firstName).isEqualTo("John");


    }
}
