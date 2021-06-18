package com.epam.rgg.controller;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.junittag.MockTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.business.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@MockTag
@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    private GameController gameController;

    @Mock
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameController = new GameController(gameService);
    }

    @Test
    void shouldReturnGame() {
        GameDto mario = GameDto.builder()
                .name("Mario").consoleType(ConsoleType.NES).year(1985)
                .build();
        when(gameService.rollGame(ConsoleType.NES)).thenReturn(mario);

        GameDto actual = gameController.getRandomGame(ConsoleType.NES);

        assertThat(actual).isEqualTo(mario);
    }
}
