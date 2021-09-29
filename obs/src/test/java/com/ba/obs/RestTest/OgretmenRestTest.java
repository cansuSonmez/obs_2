package com.ba.obs.RestTest;

import com.ba.obs.repo.OgretmenRepository;
import com.ba.obs.restControllers.OgretmenRestController;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.service.OgretmenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OgretmenRestController.class) @DisplayName(value = "Ogrenci WebMvc test") public class OgretmenRestTest
{
    @Autowired MockMvc mock;

    @MockBean OgretmenService ogretmenService;
    @MockBean OgretmenRepository ogretmenRepository;

    @Test public void getOgrenciByIdTest() throws Exception
    {
        Mockito.when(ogretmenService.getById(6)).thenReturn(new Ogretmen(6, "Onur"));
        MvcResult result = this.mock.perform(MockMvcRequestBuilders.get("/ogretmenWS/getById/6").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String ogr = result.getResponse().getContentAsString();
        Ogretmen result_ogretmen = new ObjectMapper().readValue(ogr, Ogretmen.class);
        Assertions.assertEquals(result_ogretmen, new Ogretmen(6, "Onur"));
    }
}