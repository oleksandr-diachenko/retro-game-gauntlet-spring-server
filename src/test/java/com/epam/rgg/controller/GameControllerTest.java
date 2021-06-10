package com.epam.rgg.controller;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.junittag.MockTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@MockTag
@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    private GameController gameController;

    @Mock
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameController = new GameController(gameService);
    }

    @Test
    void shouldReturnGame() {
        GameDto mario = new GameDto("Mario", ConsoleType.NES, 1985);
        when(gameService.rollGame(ConsoleType.NES)).thenReturn(mario);

        GameDto actual = gameController.getRandomGame(ConsoleType.NES);

        assertThat(actual).isEqualTo(mario);
    }
}
