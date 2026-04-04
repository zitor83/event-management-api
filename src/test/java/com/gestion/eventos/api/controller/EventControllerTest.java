package com.gestion.eventos.api.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.eventos.api.dto.EventResponseDto;
import com.gestion.eventos.api.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.mock;

@WebMvcTest(EventController.class)
class EventControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EventService eventService;

    private ObjectMapper objectMapper;


    private EventResponseDto eventResponseDto;

    static class EventContollerTestConfig {

        @Bean
        @Primary
        EventService eventService() {
            return mock(EventService.class);
        }
    }

    @BeforeEach

    void setUp(@Autowired EventService eventServiceMock){
        this.eventService = eventServiceMock;

    }



}