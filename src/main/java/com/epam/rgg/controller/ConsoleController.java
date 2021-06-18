package com.epam.rgg.controller;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;
import com.epam.rgg.business.service.ConsoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/consoles")
public class ConsoleController {

    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @GetMapping("/{type}")
    public ConsoleDto getConsole(@PathVariable ConsoleType type) {
        return consoleService.findConsole(type);
    }
}
