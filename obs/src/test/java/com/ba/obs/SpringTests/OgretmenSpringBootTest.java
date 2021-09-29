package com.ba.obs.SpringTests;

import com.ba.obs.model.Ogretmen;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.function.Consumer;

@SpringBootTest @AutoConfigureMockMvc @DisplayName(value = "Spring Boot Ogrenci MVC test") public class OgretmenSpringBootTest
{
    @Autowired MockMvc mock;

    @Test @DisplayName(value = "Get Öğretmen with mockmvc and assert") @Order(value = 1) void getOgretmenById() throws Exception
    {
        // jupiter assertions
        // veya mockmvc yerine resttemplate
        RequestBuilder request = MockMvcRequestBuilders.get("/ogretmenWS/getById/1").accept(MediaType.APPLICATION_JSON);
        Ogretmen response = new ObjectMapper().readValue(mock.perform(request).andReturn().getResponse().getContentAsString(), Ogretmen.class);
        assert response.equals(new Ogretmen(1, "Numan"));
        Assertions.assertEquals(response, new Ogretmen(1, "Numan"));
        org.assertj.core.api.Assertions.assertThat(response).isEqualTo(new Ogretmen(1, "Numan"));
    }

    @Test @DisplayName(value = "Get Öğretmen with mockmvc and expect") @Order(value = 2) void getOgretmenById2() throws Exception
    {
        this.mock.perform(MockMvcRequestBuilders.get("/ogretmenWS/getById/1")).andExpect(MockMvcResultMatchers.jsonPath("$.ogr_id").value("1")).andExpect(MockMvcResultMatchers.jsonPath("$.ogr_name").value("Numan")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}