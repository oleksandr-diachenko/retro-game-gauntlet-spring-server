package com.epam.rgg.controller;

import com.epam.rgg.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.service.ConsoleService;

public class ConsoleController {

    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    public ConsoleDto getConsole(ConsoleType consoleType) {
        return consoleService.findConsole(consoleType);
    }
}
