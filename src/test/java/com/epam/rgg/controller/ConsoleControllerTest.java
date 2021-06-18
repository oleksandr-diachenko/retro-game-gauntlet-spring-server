package com.epam.rgg.controller;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.junittag.MockTag;
import com.epam.rgg.business.service.ConsoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.epam.rgg.model.ConsoleType.NES;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@MockTag
@ExtendWith(MockitoExtension.class)
class ConsoleControllerTest {

    private ConsoleController consoleController;

    @Mock
    private ConsoleService consoleService;

    @BeforeEach
    void setUp() {
        consoleController = new ConsoleController(consoleService);
    }

    @Test
    void shouldReturnConsole() {
        ConsoleDto expected = ConsoleDto.builder().consoleType(NES).gameCount(272).build();
        when(consoleService.findConsole(NES)).thenReturn(expected);

        ConsoleDto actual = consoleController.getConsole(NES);

        assertThat(actual).isEqualTo(expected);
    }
}
