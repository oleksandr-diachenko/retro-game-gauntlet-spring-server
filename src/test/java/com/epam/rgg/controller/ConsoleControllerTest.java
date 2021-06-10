package com.epam.rgg.controller;

import com.epam.rgg.dto.ConsoleDto;
import com.epam.rgg.service.ConsoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.epam.rgg.model.ConsoleType.NES;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsoleControllerTest {

    private ConsoleController consoleController;

    @Mock
    private ConsoleService consoleService;

    @BeforeEach
    void setUp() {
        consoleController = new ConsoleController(consoleService);
    }

    @Test
    void shouldReturnConsole() {
        ConsoleDto expected = new ConsoleDto(NES, 272);
        when(consoleService.findConsole(NES)).thenReturn(expected);

        ConsoleDto actual = consoleController.getConsole(NES);

        assertThat(actual).isEqualTo(expected);
    }
}
