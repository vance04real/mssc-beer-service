package com.persistantcoder.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistantcoder.msscbeerservice.web.model.BeerDto;
import com.persistantcoder.msscbeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Evans K F C on Oct ,2019
 **/

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception{

        BeerDto beerDto  =getValidBeer();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception{
        BeerDto beerDto  =  getValidBeer();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerToJson))
                .andExpect(status().isNoContent());

    }


    private BeerDto getValidBeer(){

        return BeerDto.builder()
                .beerName("Pinball Porter")
                .beerStyleEnum(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(123123321133L)
                .build();
    }
}