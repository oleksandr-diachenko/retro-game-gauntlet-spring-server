package com.epam.rgg.controller;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.junittag.SpringTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.service.GameService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
}