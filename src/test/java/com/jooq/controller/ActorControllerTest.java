package com.jooq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jooq.dto.ActorDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ActorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    void should_get_actors() {
        mockMvc
                .perform(get("/actors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].actorId").isNotEmpty())
                .andExpect(jsonPath("$[0].firstName").isNotEmpty());

    }

    @SneakyThrows
    @Test
    void should_be_able_to_add_actor() {
        ActorDto actorDto = ActorDto.builder()
                .actorId(1)
                .firstName("Varun")
                .lastName("Dhawan")
                .lastUpdate(LocalDateTime.now())
                .build();
        String inputInJson = toJson(actorDto);

        mockMvc
                .perform(post("/actors")
                        .contentType(APPLICATION_JSON).content(inputInJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
}