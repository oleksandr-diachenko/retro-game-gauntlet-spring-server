package com.epam.rgg.business.service;

import com.epam.rgg.business.dto.ConsoleDto;
import com.epam.rgg.model.ConsoleType;
import org.springframework.stereotype.Service;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @Override
    public ConsoleDto findConsole(ConsoleType consoleType) {
        return new ConsoleDto(consoleType, 4134); //TODO mock for UI
    }
}
