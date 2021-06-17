package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.dao.repository.ConsoleRepository;
import com.epam.rgg.dao.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.epam.rgg.model.ConsoleType.NES;
import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleServiceImplTest {

    private ConsoleService consoleService;

    @Mock
    private ConsoleRepository consoleRepository;
    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    void setUp() {
        consoleService = new ConsoleServiceImpl(consoleRepository);
    }

    @Test
    void shouldReturnConsoleByConsoleType() {
        Console nes = new Console(NES);
        Game mario = new Game("Mario", 1985, nes);
        nes.addGame(mario);
        when(consoleRepository.findByType(NES)).thenReturn(of(nes));

        ConsoleDto actual = consoleService.findConsole(NES);

        ConsoleDto expected = ConsoleDto.builder().consoleType(NES).gameCount(1).build();

        assertThat(actual).isEqualTo(expected);
    }
}