package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.GameDto;
import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.dao.entity.Year;
import com.epam.rgg.dao.repository.GameRepository;
import com.epam.rgg.junittag.MockTag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static com.epam.rgg.model.ConsoleType.NES;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
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
        Console console = new Console(NES);
        Year year = new Year(1985);
        Game mario = new Game("Mario",  console, year);
        when(gameRepository.findRandomGame(NES)).thenReturn(of(mario));

        GameDto actual = gameService.rollGame(NES);

        GameDto expected = GameDto.builder()
                .name("Mario").consoleType(NES).year(1985)
                .build();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowRecordNotFoundWhenRecordNotFoundInRepository() {
        when(gameRepository.findRandomGame(any())).thenReturn(empty());

        assertThatThrownBy(() -> gameService.rollGame(NES))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Game with console type NES not found");
    }
}