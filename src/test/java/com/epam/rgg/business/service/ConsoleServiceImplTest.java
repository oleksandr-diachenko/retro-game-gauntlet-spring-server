package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.dao.entity.Console;
import com.epam.rgg.dao.entity.Game;
import com.epam.rgg.dao.entity.Year;
import com.epam.rgg.dao.repository.ConsoleRepository;
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

@ExtendWith(MockitoExtension.class)
class ConsoleServiceImplTest {

    private ConsoleService consoleService;

    @Mock
    private ConsoleRepository consoleRepository;

    @BeforeEach
    void setUp() {
        consoleService = new ConsoleServiceImpl(consoleRepository);
    }

    @Test
    void shouldReturnConsoleByConsoleType() {
        Console nes = new Console(NES);
        Year year = new Year(1985);
        Game mario = new Game("Mario", nes, year);
        nes.addGame(mario);
        when(consoleRepository.findByType(NES)).thenReturn(of(nes));

        ConsoleDto actual = consoleService.findConsole(NES);

        ConsoleDto expected = ConsoleDto.builder().consoleType(NES).gameCount(1).build();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldThrowEntityNotFoundExceptionWhenRepositoryReturnsEmptyOptional() {
        when(consoleRepository.findByType(any())).thenReturn(empty());

        assertThatThrownBy(() -> consoleService.findConsole(NES))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("Console with name NES not found");
    }
}