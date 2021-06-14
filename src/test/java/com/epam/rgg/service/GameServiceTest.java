package com.epam.rgg.service;

import com.epam.rgg.dto.GameDto;
import com.epam.rgg.entity.Console;
import com.epam.rgg.entity.Game;
import com.epam.rgg.junittag.MockTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@MockTag
@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl(gameRepository);
    }

    @Test
    void shouldReturnGameDto() {
        Console console = new Console(1, ConsoleType.NES);
        Game mario = new Game(1, "Mario", 1985, console);
        when(gameRepository.findRandomGame(ConsoleType.NES)).thenReturn(mario);

        GameDto actual = gameService.rollGame(ConsoleType.NES);

        GameDto expected = GameDto.builder()
                .name("Mario").consoleType(ConsoleType.NES).year(1985)
                .build();
        assertThat(actual).isEqualTo(expected);
    }
}