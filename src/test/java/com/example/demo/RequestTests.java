package com.example.demo;


import com.example.demo.logic.controllers.LoginRestController;
import com.example.demo.logic.controllers.OrderRestController;
import com.example.demo.logic.controllers.RegisterController;
import com.example.demo.logic.controllers.ResultController;
import com.example.demo.logic.PizzaName;
import com.example.demo.logic.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest({LoginRestController.class, RegisterController.class, OrderRestController.class, ResultController.class})

 public class RequestTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private WebTestClient webClient;

    @Test
    public void shouldAddOrder() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders
                        .post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(PizzaName.Chicago)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldDelOrder() throws Exception {
        mvc
                .perform(MockMvcRequestBuilders
                        .post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PizzaName.Chicago.toString())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        mvc
                .perform(MockMvcRequestBuilders
                        .delete("/order/{name}", PizzaName.Chicago))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldNotDelOrder() throws Exception {

        mvc
                .perform(MockMvcRequestBuilders
                        .post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PizzaName.Chicago.toString())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        mvc
                .perform(MockMvcRequestBuilders
                        .delete("/order/{name}", PizzaName.Sicilian))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
    @Test
    public void logIn() throws Exception {
        var user = new User();
        user.setName("Vasya");
        user.setPhoneNumber("123456");
        mvc
                .perform(MockMvcRequestBuilders
                        .get("/login", user)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PizzaName.Chicago)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}