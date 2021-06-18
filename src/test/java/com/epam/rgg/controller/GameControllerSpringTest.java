package com.epam.rgg.controller;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.junittag.SpringTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.business.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringTag
@WebMvcTest(GameController.class)
class GameControllerSpringTest {

    @Autowired
    private GameController gameController;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;

    @Test
    void shouldContextLoaded() {
        assertThat(gameController).isNotNull();
    }

    @Test
    void shouldReturnGame() throws Exception {
        GameDto mario = GameDto.builder()
                .name("Mario").consoleType(ConsoleType.NES).year(1985)
                .build();
        when(gameService.rollGame(ConsoleType.NES)).thenReturn(mario);

        mockMvc.perform(get("/v1/games/random/NES"))
                .andExpect(jsonPath("$.name", is("Mario")))
                .andExpect(jsonPath("$.consoleType", is("NES")))
                .andExpect(jsonPath("$.year", is(1985)));
    }

    @Test
    void shouldReturn404WhenServiceThrowRecordNotFoundException() throws Exception {
        when(gameService.rollGame(ConsoleType.NES)).thenThrow(new EntityNotFoundException("Not found"));

        mockMvc.perform(get("/v1/games/random/NES"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is("NOT_FOUND")))
                .andExpect(jsonPath("$.message", is("Not found")));
    }
}