package com.epam.rgg.controller;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.junittag.SpringTag;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.business.service.ConsoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.epam.rgg.model.ConsoleType.NES;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringTag
@WebMvcTest(ConsoleController.class)
class ConsoleControllerSpringTest {

    @Autowired
    private ConsoleController consoleController;
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsoleService consoleService;

    @Test
    void shouldContextLoaded() {
        assertThat(consoleController).isNotNull();
    }

    @Test
    void shouldReturnConsole() throws Exception {
        ConsoleDto consoleDto = ConsoleDto.builder().consoleType(NES).gameCount(764).build();
        when(consoleService.findConsole(NES)).thenReturn(consoleDto);

        mockMvc.perform(get("/v1/consoles/NES"))
                .andExpect(jsonPath("$.consoleType", is("NES")))
                .andExpect(jsonPath("$.gameCount", is(764)));
    }
}